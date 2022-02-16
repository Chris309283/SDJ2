public class StartTaskExample
{
  public static void main(String[] args)
  {
    BlockingQueue queue = new BlockingQueue(10);

    for (int i = 0; i < 10; i++)
    {
      Thread p = new Thread(new TaskProducer(queue,i));
      Thread c = new Thread(new TaskConsumer(queue,i));
      p.start();
      c.start();
    }
  }
}
