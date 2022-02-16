import Deposit.Deposit;
import Mine.Valuable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ValuableTransporter implements Runnable
{
  private ArrayList<Valuable> transportBag;
  private Deposit deposit;
  private String name;
  private TreasureRoomDoor treasure;

  public ValuableTransporter(String name, Deposit deposit,
      TreasureRoomDoor treasure)
  {
    this.treasure = treasure;
    this.deposit = deposit;
    this.transportBag = new ArrayList<>();
    this.name = name;
  }

  @Override public void run()
  {
    Archive archive = Archive.getInstance();
    Thread.currentThread().setName(name);
    while (true)
    {
      int ranNumber = ThreadLocalRandom.current().nextInt(50, 200 + 1);
      int value = 0;
      do
      {
        Valuable valuable = null;
        try
        {
          valuable = deposit.take();
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        transportBag.add(valuable);
        archive.log(
            "The Valuable Transporter took a " + valuable.getType() + " worth: "
                + valuable.getValue());
        value += valuable.getValue();
      }
      while (value < ranNumber);
      archive.log("The Transporter took valuables worth: " + value);
      treasure.acquireWrite();
      treasure.add(this, transportBag);
      treasure.releaseWrite();
      transportBag.clear();
      archive.log("The Transporter put the valuables in the treasure room");
      /*  archive.log("The Transporter has lost all the valuables");*/
      try
      {
        Thread.sleep(10000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
