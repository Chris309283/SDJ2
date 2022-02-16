import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue
{
  private Queue<Task> queue;
  private int capacity;

  public BlockingQueue(int capacity)
  {
    this.capacity = capacity;
    queue = new LinkedList<>();
  }

  public synchronized void addTask(Task task)
  {
    while (queue.size() >= capacity)
    {
      try
      {
        System.out.println("queue was full");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    queue.add(task);
    notifyAll();
  }

  public synchronized Task retrieveTask()
  {
    while (queue.isEmpty())
    {
      try
      {
        System.out.println("queue was empty");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    Task task = queue.poll();
    notifyAll();
    return task;
  }
}
