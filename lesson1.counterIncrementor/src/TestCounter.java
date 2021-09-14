public class TestCounter
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    CounterIncrementer c1 = new CounterIncrementer(counter, 200000,"incrementer1");
    CounterIncrementer c2 = new CounterIncrementer(counter, 200000,"incrementer2");
    Thread t1 = new Thread(c1, "Incrementer1");
    Thread t2 = new Thread(c2, "Incrementer2");
    t1.start();
    t2.start();
    System.out.println(Thread.currentThread().getName() + " " + counter.getValue());
  }
}
