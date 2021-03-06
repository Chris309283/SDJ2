package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient
{
  private Socket socket;
  private DataInputStream in;
  private DataOutputStream out;
  private Scanner input;

  public TaskListClient(String host, int port) throws IOException
  {
    this.socket = new Socket(host, port);
    this.in = new DataInputStream(socket.getInputStream());
    this.out = new DataOutputStream(socket.getOutputStream());
    this.input = new Scanner(System.in);
    execute();
  }

  private void execute() throws IOException
  {
    boolean run = true;
    while (run)
    {
      System.out.println("1) Add a task");
      System.out.println("2) Get a task");
      System.out.println("3) get task size");
      System.out.println("Any other number) Exit");

      int choice = input.nextInt();
      out.writeInt(choice);

      switch (choice)
      {
        case 1:
          addTask();
          break;
        case 2:
          getTask();
          break;
        case 3:
          System.out.println("Server> " + in.readInt());
          break;
        default:
          run = false;
          break;
      }
    }
    socket.close();
  }

  private void getTask() throws IOException
  {
    String reply = in.readUTF();
    if (reply.equals("ERROR"))
    {
      System.out.println("server> " + reply);
    }
    else
    {
      long tTime = in.readLong();
      System.out.println("server> " + reply + ": " + tTime);
    }
  }

  private void addTask() throws IOException
  {
    System.out.println("Enter the task: ");
    input.nextLine();
    String task = input.nextLine();
    System.out.println("Enter the estimated time: ");
    int taskTime = input.nextInt();
    out.writeUTF(task);
    out.writeInt(taskTime);
    System.out.println(in.readUTF());
  }
}
