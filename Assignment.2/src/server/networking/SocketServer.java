package server.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  public void startServer()
  {
    final int PORT = 2910;
    try
    {

      System.out.println("Starting Server...");
      ServerSocket listenSocket = new ServerSocket(PORT);

      while (true)
      {
        System.out.println("Waiting for clients...");
        Socket socket = listenSocket.accept();
        new Thread(new SocketHandler()).start();
        System.out.println("A client has connected " + socket.getInetAddress().getHostAddress());
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
