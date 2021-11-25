import Mine.Valuable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TEST
{
  public static void main(String[] args)
  {
    BlockingQueue<Valuable> deposit = new ArrayBlockingQueue<>(500);
   Miner miner = new Miner(deposit);
   ValuableTransporter valuableTransporter = new ValuableTransporter(deposit);

   new Thread(miner).start();
   new Thread(valuableTransporter).start();
  }
}
