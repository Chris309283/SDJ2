package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TPCMultiThreadedServer
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 6789;
    System.out.println("Starting Server...");

    ServerSocket listenSocket = new ServerSocket(PORT);

    while (true)
    {
      System.out.println("Waiting for clients...");
      Socket socket = listenSocket.accept();

      ClientHandler clientHandler = new ClientHandler(socket);
      Thread t = new Thread(clientHandler);
      t.start();
      System.out.println("A client has connected");
    }
  }
}
