import Deposit.Deposit;
import Mine.Mine;
import Mine.Valuable;

public class Miner implements Runnable
{
  private Deposit deposit;
  private Mine mine;
  private String name;

  public Miner(String name,Deposit deposit, Mine mine)
  {
    this.deposit = deposit;
    this.mine = mine;
    this.name = name;
  }

  @Override public void run()
  {
    Thread.currentThread().setName(name);
    Archive archive = Archive.getInstance();
try
{
  while (true)
  {
    Valuable valuable = mine.mineValuable();
    archive.log("Miner mined a " + valuable.getType() + " with a value of " + valuable.getValue());
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
