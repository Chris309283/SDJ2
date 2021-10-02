package server;

import com.google.gson.Gson;
import model.Message;
import model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable
{
  private BufferedReader in;
  private PrintWriter out;

  public ClientHandler(Socket socket) throws IOException
  {
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    out = new PrintWriter(socket.getOutputStream(),true);
  }

  @Override public void run()
  {
    try
    {
      String clientText = in.readLine();
      System.out.println("Client> " + clientText);

      Gson gson = new Gson();
      Student student = gson.fromJson(clientText,Student.class);
      System.out.println("Student: " + student);

      Message reply = new Message("Welcome",student);
      System.out.println("Reply: " + reply);

      String replyJson= gson.toJson(reply);

      System.out.println("Server> " + replyJson);
      out.println(replyJson);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
