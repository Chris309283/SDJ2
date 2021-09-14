public class Test
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(200,0);
    CounterIncrementer counterIncrementer1 = new CounterIncrementer(counter, 200);
    CounterIncrementer counterIncrementer2 = new CounterIncrementer(counter, 200);
    CounterDecrementer counterDecrementer3 = new CounterDecrementer(counter, 200);
    CounterDecrementer counterDecrementer4 = new CounterDecrementer(counter, 200);

    Thread t1 = new Thread(counterIncrementer1);
    Thread t2 = new Thread(counterIncrementer2);
    Thread t3 = new Thread(counterDecrementer3);
    Thread t4 = new Thread(counterDecrementer4);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
