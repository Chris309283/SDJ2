package Login.server.mediator;

import Login.server.model.Model;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClientHandler implements Runnable
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private boolean running;
  private Gson gson;
  private String clientIp;
  private Model model;

  public UserClientHandler(Socket socket, Model model) throws IOException
  {
    this.socket = socket;
    this.model = model;
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
    this.gson = new Gson();
    this.clientIp = socket.getInetAddress().getHostAddress();
  }

  public void close()
  {

  }

  @Override public void run()
  {
    try
    {
      String clientText = in.readLine();
      System.out.println("Server> " + clientText);
      UserPackage userPackage = gson.fromJson(clientText, UserPackage.class);
      model.addUser(userPackage.getUser(), userPackage.getPassword());
      out.println("Success: you are now logged in");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      out.println(e.getMessage());
    }
  }
}
