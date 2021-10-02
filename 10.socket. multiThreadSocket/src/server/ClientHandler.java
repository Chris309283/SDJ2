package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable
{
  private BufferedReader in;
  private PrintWriter out;
  private Socket socket;

  public ClientHandler(Socket socket) throws IOException
  {
    this.socket = socket;
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
  }

  @Override public void run()
  {
    try
    {
      String request = in.readLine();
      System.out.println("Client[" + socket.getPort()+"]>" + request);
      String reply = request.toUpperCase();

      System.out.println("Server> " + reply);
      out.println(reply);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
