package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TaskListCommunicationThreadHandler implements Runnable
{
  private DataInputStream in;
  private DataOutputStream out;
  private String ip;
  private TaskList tasks;

  public TaskListCommunicationThreadHandler(Socket socket, TaskList tasks)
      throws IOException
  {
    this.tasks = tasks;
    this.in = new DataInputStream(socket.getInputStream());
    this.out = new DataOutputStream(socket.getOutputStream());
    this.ip = socket.getInetAddress().getHostAddress();
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        int toDo = in.readInt();
        System.out.println("client " + ip + "> " + toDo);
        if (toDo == 1 || toDo == 2 || toDo == 3)
        {
          switch (toDo)
          {
            case 1:

              String task = in.readUTF();
              System.out.println("client " + ip + "> " + task);
              int taskTime = in.readInt();
              System.out.println("client " + ip + "> " + taskTime);
              tasks.add(new Task(task, taskTime));
              out.writeUTF("Server> Task has been added");
              break;

            case 2:
              if (tasks.size() == 0)
              {
                out.writeUTF("ERROR");
                System.out.println("Server> ERROR");
              }
              else
              {
                Task task1 = tasks.getAndRemoveNextTask();
                out.writeUTF(task1.getText());
                out.writeLong(task1.getEstimatedTime());
                System.out.println("Server> " + task1.getText() + ": "
                    + task1.getEstimatedTime());
              }
              break;

            case 3:
              out.writeInt(tasks.size());
              System.out.println("Server> " + tasks.size());
              break;
          }
        }
        else
        {
          out.writeUTF("EXIT");
          System.out.println("Server> EXIT");
          System.out.println("client " + ip + " has been disconnected");
          break;
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
