package Server;

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
        switch (toDo)
        {
          case 1:

            String task = in.readUTF();
            int taskTime = in.readInt();
            tasks.add(new Task(task,taskTime));
            out.writeUTF("Server> Task has been added");
            break;

          case 2:
            if (tasks.size()==0)
            {
              out.writeUTF("ERROR");
            }
            else
            {
              String taskReturn = tasks.getAndRemoveNextTask().getText();
              long taskEstimate = tasks.getAndRemoveNextTask().getEstimatedTime();
              out.writeUTF("Server> " + taskReturn + ": " + taskEstimate);
            }
            break;

          case 3:
            int taskSize = tasks.size();
            out.writeUTF("Server> " + taskSize);
            break;

          default:
            out.writeUTF("Server> EXIT");
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
