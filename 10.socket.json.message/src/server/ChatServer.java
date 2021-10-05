package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{
  private ServerSocket welcomeSocket;

  public ChatServer(int port) throws IOException
  {
    this.welcomeSocket = new ServerSocket(port);
  }

  public void execute() throws IOException
  {
    System.out.println("Starting Server... ");
    int count = 1;
    while (true)
    {
      System.out.println("Waiting for clients...");
      Socket socket = welcomeSocket.accept();
      Runnable cth = new CommunicationThreadHandler(socket);
      Thread t = new Thread(cth);
      t.start();
      System.out.println("Client number: " + count + " connected");
      count++;
    }
  }
}
