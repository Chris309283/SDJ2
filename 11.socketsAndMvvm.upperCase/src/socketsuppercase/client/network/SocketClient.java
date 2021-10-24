package socketsuppercase.client.network;

import socketsuppercase.shared.transferobjects.LogEntry;
import socketsuppercase.shared.transferobjects.Requestt;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client {

    private PropertyChangeSupport support;

    public SocketClient() {
        support = new PropertyChangeSupport(this);
    }

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 2910);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            new Thread(() -> listenToServer(outToServer, inFromServer)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer) {
        try {
            outToServer.writeObject(new Requestt("Listener", null));
            while (true) {
                Requestt requestt = (Requestt) inFromServer.readObject();
                support.firePropertyChange(requestt.getType(), null, requestt.getArg());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toUpperCase(String str) {
        try {
            Requestt response = request(str, "Uppercase");
            return (String)response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public List<LogEntry> getLog() {
        try {
            Requestt response = request(null, "FetchLog");
            return (List<LogEntry>) response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public String toLowerCase(String str)
    {
        try {
            Requestt response = request(str, "LowerCase");
            return (String)response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override public String toCamelCase(String str)
    {
        try {
            Requestt response = request(str, "CamelCase");
            return (String)response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }

    private Requestt request(String arg, String type) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 2910);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        outToServer.writeObject(new Requestt(type, arg));
        return (Requestt) inFromServer.readObject();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
