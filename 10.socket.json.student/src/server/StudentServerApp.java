package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServerApp
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 6789;
    System.out.println("Starting server...");

    ServerSocket listenSocket = new ServerSocket(PORT);
    while (true)
    {
      System.out.println("Waiting for a client...");
      Socket socket = listenSocket.accept();

      Thread clientThread = new Thread(new ClientHandler(socket));
      clientThread.start();
    }
  }
}
