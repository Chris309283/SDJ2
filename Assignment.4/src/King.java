import Mine.Valuable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class King implements Runnable
{
  private ArrayList<Valuable> partyBag;
  private TreasureRoomDoor treasure;

  public King(TreasureRoomDoor treasure)
  {
    this.treasure = treasure;
    this.partyBag = new ArrayList<>();
  }

  @Override public void run()
  {
    Archive archive = Archive.getInstance();
    Thread.currentThread().setName("King");

    while (true)
    {
      archive.log("----------------------------------------->King looking too party");
      int partyBudget = ThreadLocalRandom.current().nextInt(0, 150 + 1);
      double total = 0;

      while (treasure.look(this) >= 2)
      {
        treasure.acquireWrite();
        Valuable valuable = treasure.retrieve(this);
        total += valuable.getValue();
        partyBag.add(valuable);
        archive.log("----------------------------------------->The king took a " + valuable.getType() + " into his party bag");
        try
        {
          Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      if (total < partyBudget)
      {
        treasure.add(this, partyBag);
        archive.log("----------------------------------------->This King didn't have money for a party!");
      }
      else
      {
        partyBag.clear();
        archive.log("-------------------------------------------->PARTY TIME!!! KING HOLDS A PARTY");
      }
      treasure.releaseWrite();
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
