package client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient
{
  private Scanner input;
  private BufferedReader in;
  private PrintWriter out;
  private Socket socket;
  private Gson gson;

  public ChatClient(String host, int port) throws IOException
  {
    this.socket = new Socket(host, port);
    this.input = new Scanner(System.in);
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
    this.gson = new Gson();
  }

  public void execute() throws IOException
  {
    while (true)
    {
      String messageText = input.nextLine();
      System.out.println("Client> " +messageText);

      Message message = new Message("test",messageText);
      String jsonMessage = gson.toJson(message);

      System.out.println("Client> " + jsonMessage);
      out.println(jsonMessage);

      if (messageText.equals("EXIT"))
      {
        close();
        break;
      }
    }
  }

  public void close() throws IOException
  {
   socket.close();
   input.close();
  }
}
