public class CounterIncrementer implements Runnable
{
  private Counter counter;
  private int updates;

  public CounterIncrementer(Counter counter, int updates)
  {
    this.counter = counter;
    this.updates = updates;
  }

  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      counter.increment();
      System.out.println("incremented to =" + counter.getValue());
    }
  }
}
