package server;

import client.Message;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CommunicationThreadHandler implements Runnable
{
  private BufferedReader in;
  private PrintWriter out;
  private Socket socket;
  private String ip;
  private Gson gson;

  public CommunicationThreadHandler(Socket socket) throws IOException
  {
    this.socket = socket;
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
    this.ip = socket.getInetAddress().getHostAddress();
    this.gson = new Gson();
  }

  @Override public void run()
  {
    try
    {
      while (true)
      {
        String json = in.readLine();
        System.out.println("Client " + ip + "> " + json);
        Message message = gson.fromJson(json, Message.class);
        System.out.println("Client " + ip + "> " + message);

        if (message.getBody().equals("EXIT"))
        {
          break;
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
