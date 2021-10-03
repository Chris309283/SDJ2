package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer
{
  private ServerSocket welcomeSocket;
  private TaskList taskList;

  public TaskListServer(TaskList taskList, int port) throws IOException
  {
    this.taskList = taskList;
    this.welcomeSocket = new ServerSocket(port);
    execute();
  }

  private void execute() throws IOException
  {
    System.out.println("Starting Server... ");
    int count = 1;
    while (true)
    {
      System.out.println("Waiting for clients...");
      Socket socket = welcomeSocket.accept();
      Runnable tlcth = new TaskListCommunicationThreadHandler(socket,taskList);
      Thread t = new Thread(tlcth);
      t.start();
      System.out.println("Client number: " + count + " connected");
      count++;
    }
  }
}
