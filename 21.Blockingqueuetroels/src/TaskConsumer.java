public class TaskConsumer implements Runnable
{
  private BlockingQueue queue;
  private String name;

  public TaskConsumer(BlockingQueue queue, int id)
  {
    this.queue = queue;
    this.name = "Consumer " + id;
  }

  @Override public void run()
  {
    while (true)
    {
      Task task = queue.retrieveTask();
      int result = task.a + task.b;
      System.out.println(name + " calculated result: " + result);
    }
  }
}
