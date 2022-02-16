import Mine.Valuable;

import java.util.ArrayList;

public class TreasureRoom implements TreasureRoomDoor
{
  private ArrayList<Valuable> treasure;
  private int total;

  public TreasureRoom()
  {
    this.treasure = new ArrayList<>();
    this.total = 0;
  }

  @Override public void acquiredRead()
  {

  }

  @Override public void releaseRead()
  {

  }

  @Override public void acquireWrite()
  {

  }

  @Override public void releaseWrite()
  {

  }

  @Override public synchronized void add(Runnable character,
      ArrayList<Valuable> valuableTransportBag)
  {
    for (Valuable valuable : valuableTransportBag)
    {
      treasure.add(valuable);
      total += valuable.getValue();
    }
  }

  @Override public synchronized Valuable retrieve(Runnable character)
  {
    if (treasure.isEmpty())
    {
      return null;
    }
    total -= treasure.get(0).getValue();
    return treasure.remove(0);
  }

  @Override public synchronized int look(Runnable character)
  {
    return total;
  }
}
