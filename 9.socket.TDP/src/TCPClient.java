import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 6789;
    final String HOST = "localhost";

    // create a scanner to take user input
    Scanner input = new Scanner(System.in);

    // create a client socket and connect to the server
    Socket clientSocket = new Socket(HOST, PORT);

    // create an input stream attached to the socket
    BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));

    // create an output stream attached to the socket
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

    // read a line form user input
    System.out.print("Write a line for the server: ");
    String request = input.nextLine();
    System.out.println("Client> " + request);

    // send line to server
    out.println(request);

    // read line from the server
    String reply = in.readLine();
    System.out.println("Server> "+ reply);

    //close the socket
    clientSocket.close();
  }
}
