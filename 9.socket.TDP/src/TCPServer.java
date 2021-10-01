import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 6789;
    System.out.println("Starting Server...");

    // creating server-socket at port 6789 listening for clients
    ServerSocket listenSocket = new ServerSocket(PORT);

    while (true)
    {
      System.out.println("Waiting for clients...");
      Socket socket = listenSocket.accept();

      // create input stream attached to the socket
      // inputStream, InputStreamReader, BufferedReader
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      // create output stream attached to the socket
      PrintWriter outWriter = new PrintWriter(socket.getOutputStream(), true);

      // read line from client
      String request = in.readLine();
      System.out.println("Client> " + request);
      String reply = request.toUpperCase();

      //send lind to client
      System.out.println("Server> " + reply);
      outWriter.println(reply);

      // loop back and wait for another client
    }
  }
}
