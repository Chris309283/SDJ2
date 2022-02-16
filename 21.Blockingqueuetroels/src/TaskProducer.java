import java.util.Random;

public class TaskProducer implements Runnable
{
  private BlockingQueue queue;
  private String name;

  public TaskProducer(BlockingQueue queue, int id)
  {
    this.queue = queue;
    this.name = "Producer " + id;
  }

  @Override public void run()
  {
    Random random = new Random();

    while (true)
    {
      int a = random.nextInt(100);
      int b = random.nextInt(100);
      Task task = new Task(a, b);
      queue.addTask(task);
      System.out.println(name + " added task (" + a + ", " + b + ")");
    }
  }
}
