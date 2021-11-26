public class Guardsman implements TreasureRoomDoor
{
  private int writers, readers;

  public Guardsman()
  {
    writers = 0;
    readers = 0;
  }

  @Override public synchronized void acquiredRead()
  {
    try
    {
      while (writers > 0)
      {
        System.out.println(
            Thread.currentThread().getName() + " WAITING" + "(Readers: "
                + readers + ")");
        wait();
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " Reading");
    readers++;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    System.out.println(Thread.currentThread().getName() + " has been released from reading");
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
        System.out.println(Thread.currentThread().getName() + " WAIT" +"(Writers: " + writers+")");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + " Writing");
    writers++;
  }

  @Override public synchronized void releaseWrite()
  {
   writers--;
    System.out.println(Thread.currentThread().getName() + " has been released from writing");
    notifyAll();
  }
}
