import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
        System.out.println("Client "+ clientIP +" reply: " + connectRequest + " does not match protocol");
        System.out.println("Client has been Disconnected");
        outWriter.println("Disconnected");
      }
      else
      {
        System.out.println("Client " + clientIP + "> " + connectRequest);
        String connected = "Connected";
        System.out.println("Server> " + connected);
        outWriter.println(connected);

        String s1;
        ArrayList<String> list = new ArrayList<>();
        do
        {
           s1 = in.readLine();
          System.out.println("Client> " + s1);
          list.add(s1);
        }
        while (!s1.equals("exit"));

        list.remove(list.size()-1);

        System.out.println("Server> " + list);
        outWriter.println(list);
        System.out.println("Client " + clientIP + " has disconnected");
      }
    }
  }
}
