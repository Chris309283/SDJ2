package client;

import com.google.gson.Gson;
import server.Task;

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
  private Gson gson;

  public TaskListClient(String host, int port) throws IOException
  {
    this.socket = new Socket(host, port);
    this.in = new DataInputStream(socket.getInputStream());
    this.out = new DataOutputStream(socket.getOutputStream());
    this.input = new Scanner(System.in);
    this.gson = new Gson();
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
      Task task = gson.fromJson(reply,Task.class);
      System.out.println("Server> " + task.getText() +": " + task.getEstimatedTime());
    }
  }

  private void addTask() throws IOException
  {
    System.out.println("Enter the task: ");
    input.nextLine();
    String taskText = input.nextLine();
    System.out.println("Enter the estimated time: ");
    int taskTime = input.nextInt();
    Task task = new Task(taskText,taskTime);
    String jsonTask = gson.toJson(task);
    out.writeUTF(jsonTask);
    System.out.println(in.readUTF());


  }
}
