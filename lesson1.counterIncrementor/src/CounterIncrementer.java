public class CounterIncrementer implements Runnable
{
  private int updates;
  private Counter counter;
  private String name;

  public CounterIncrementer(Counter counter, int updates, String name)
  {
    this.updates = updates;
    this.counter = counter;
    this.name = name;
  }

  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      counter.increment();
    }
    System.out.println(name + " finished with Counter.value =" + counter.getValue());
  }
}
