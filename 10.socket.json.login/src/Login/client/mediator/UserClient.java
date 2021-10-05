package Login.client.mediator;

import Login.client.model.Model;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClient implements Model
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Gson gson;

  public UserClient(String host, int port) throws IOException
  {
    this.socket = new Socket(host, port);
    this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(),true);
    this.gson = new Gson();
  }

  public void disconnect()
  {

  }

  @Override public void login(String userName, String password)
      throws IllegalStateException, IllegalArgumentException
  {

    try
    {
      User user = new User(userName,password);
      String json = gson.toJson(user);
      out.println(json);
      String reply = in.readLine();
      System.out.println(reply);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
