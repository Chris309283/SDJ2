import Deposit.Deposit;
import Mine.Mine;
import Mine.Valuable;

public class Miner implements Runnable
{
  private Deposit deposit;
  private Mine mine;

  public Miner(Deposit deposit)
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
