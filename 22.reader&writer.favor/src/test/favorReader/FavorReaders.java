package test.favorReader;

import test.ReadWrite;

public class FavorReaders implements ReadWrite
{
  private int readers, writers;

  public FavorReaders()
  {
    readers = 0;
    writers = 0;
  }

  @Override public synchronized void acquireRead()
  {
    while (writers > 0)
    {
      try
      {
        System.out.println(Thread.currentThread().getName() + " WAIT" +"(Readers: " + readers+")");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + " Reading");
    readers++;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
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
   // System.out.println("Writers: " + writers);
  }

  @Override public synchronized void releaseWrite()
  {
    writers--;
    //System.out.println("Writers: " + writers);
    notifyAll();
  }
}
