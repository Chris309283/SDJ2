import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 5678;
    System.out.println("Starting Server...");

    ServerSocket listenSocket = new ServerSocket(PORT);

    while (true)
    {
      System.out.println("Waiting for Clients...");
      Socket serverSocket = listenSocket.accept();

      BufferedReader in = new BufferedReader(
          new InputStreamReader(serverSocket.getInputStream()));

      PrintWriter outWriter = new PrintWriter(serverSocket.getOutputStream(),
          true);

      String clientIP = serverSocket.getInetAddress().getHostAddress();

      String connectRequest = in.readLine();

      if (!connectRequest.equals("connect"))
      {
        System.out.println("Client " + clientIP + " reply: " + connectRequest
            + " does not match protocol");
        outWriter.println("Disconnected");
        serverSocket.close();
      }


    }
  }
}