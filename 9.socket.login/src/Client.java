import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 5678;
    final String HOST = "localhost";

    Scanner input = new Scanner(System.in);

    Socket clientSocket = new Socket(HOST,PORT);

    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    PrintWriter outWriter = new PrintWriter(clientSocket.getOutputStream(),true);

    System.out.println("Connect to server?");
    String connectRequest = input.nextLine();
    outWriter.println(connectRequest);

    String reply = in.readLine();
    System.out.println("Server> " + reply);
    if (reply.equals("Disconnected"))
    {
      clientSocket.close();
    }
    else
    {
      String usernameRequest = input.nextLine();
      outWriter.println(usernameRequest);

      String reply2 = in.readLine();
      System.out.println("Server> " + reply2);
      String passwordRequest = input.nextLine();
      outWriter.println(passwordRequest);

      String reply3 = in.readLine();
      System.out.println("Server> " + reply3);
    }
  }
}
