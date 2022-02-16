import Mine.Valuable;

import java.util.ArrayList;

public class Guardsman implements TreasureRoomDoor
{
  private int writers, readers;
  private TreasureRoom treasureRoom;
  private Archive archive;

  public Guardsman()
  {
    this.treasureRoom = new TreasureRoom();
    this.writers = 0;
    this.readers = 0;
    this.archive = Archive.getInstance();
  }

  @Override public synchronized void acquiredRead()
  {
    try
    {
      while (writers > 0)
      {
        archive.log(
            Thread.currentThread().getName() + " WAITING" + "(Readers: "
                + readers + ")");
        wait();
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    archive.log(Thread.currentThread().getName() + " Reading");
    readers++;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    archive.log(Thread.currentThread().getName() + " has been released from reading");
    if (readers == 0)
    {
      notify();
    }
  }

  @Override public synchronized void acquireWrite()
  {
    while (readers > 0 || writers > 0)
    {
      try
      {
        archive.log(Thread.currentThread().getName() + " WAIT" +"(Writers: " + writers+")");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    archive.log(Thread.currentThread().getName() + " Writing");
    writers++;
  }

  @Override public synchronized void releaseWrite()
  {
   writers--;
    archive.log(Thread.currentThread().getName() + " has been released from writing");
    notifyAll();
  }

  @Override public synchronized void add(Runnable character,
      ArrayList<Valuable> valuableTransportBag)
  {
    if (character instanceof King || character instanceof ValuableTransporter)
    {
      treasureRoom.add(character,valuableTransportBag);
    }
    else
    archive.log("Access denied");
  }

  @Override public synchronized Valuable retrieve(Runnable character)
  {
    if (character instanceof King)
    {
      return treasureRoom.retrieve(character);
    }
    else
      archive.log("Access denied");
    return null;
  }

  @Override public synchronized int look(Runnable character)
  {
    if (character instanceof King || character instanceof ValuableTransporter || character instanceof Accountant)
    {
      return treasureRoom.look(character);
    }
    else
      archive.log("Access denied");
    return -1;
  }
}
