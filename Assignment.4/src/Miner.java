import Mine.Mine;
import Mine.Valuable;

import java.util.concurrent.BlockingQueue;

public class Miner implements Runnable
{
  private BlockingQueue<Valuable> deposit;
  private Mine mine;

  public Miner(BlockingQueue<Valuable> deposit)
  {
    this.deposit = deposit;
    this.mine = new Mine();
  }

  @Override public void run()
  {
try
{
  while (true)
  {
    Valuable valuable = mine.mineValuable();
    System.out.println("Miner mined a " + valuable.getType() + " with a value of " + valuable.getValue());
    deposit.put(valuable);
    Thread.sleep(500);
  }
}
catch (InterruptedException e)
{
  e.printStackTrace();
}
  }
}
