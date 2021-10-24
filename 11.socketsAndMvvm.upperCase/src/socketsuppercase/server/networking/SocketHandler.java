package socketsuppercase.server.networking;

import socketsuppercase.server.model.TextManager;
import socketsuppercase.shared.transferobjects.LogEntry;
import socketsuppercase.shared.transferobjects.Requestt;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable {

    private Socket socket;
    private TextManager textManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public SocketHandler(Socket socket, TextManager textManager) {
        this.socket = socket;
        this.textManager = textManager;

        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Requestt requestt = (Requestt) inFromClient.readObject();
            if("Listener".equals(requestt.getType())) {
                textManager.addListener("NewLogEntry", this::onNewLogEntry);
            } else if("Uppercase".equals(requestt.getType())) {
                String result = textManager.toUpperCase((String) requestt.getArg());
                outToClient.writeObject(new Requestt("Uppercase", result));
            } else if("FetchLog".equals(requestt.getType())) {
                List<LogEntry> log = textManager.getLog();
                outToClient.writeObject(new Requestt("FetchLog", log));
            }else if("LowerCase".equals(requestt.getType())) {
                String result = textManager.toLowerCase((String) requestt.getArg());
                outToClient.writeObject(new Requestt("LowerCase", result));
            }else if("CamelCase".equals(requestt.getType())) {
                String result = textManager.toCamelCase((String) requestt.getArg());
                outToClient.writeObject(new Requestt("CamelCase", result));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void onNewLogEntry(PropertyChangeEvent evt) {
        try {
            outToClient.writeObject(new Requestt(evt.getPropertyName(), evt.getNewValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
