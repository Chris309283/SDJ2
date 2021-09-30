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
  }

  private void execute() throws IOException
  {
    System.out.println("Starting Server... ");
    while (true)
    {
      System.out.println("Waiting for clients...");
      Socket socket = welcomeSocket.accept();
      Runnable TLCTH = new TaskListCommunicationThreadHandler(socket,taskList);
      Thread t1 = new Thread(TLCTH);
      t1.start();
    }
  }
}
