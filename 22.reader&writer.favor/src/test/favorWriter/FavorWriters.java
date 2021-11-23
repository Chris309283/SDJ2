package test.favorWriter;

import test.ReadWrite;

public class FavorWriters implements ReadWrite
{
  private int readers, writers;

  public FavorWriters()
  {
    readers = 0;
    writers = 0;
  }

  @Override public void acquireRead()
  {
    while (readers > 0 || writers > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    readers++;
  }

  @Override public void releaseRead()
  {
    readers--;
    notifyAll();
  }

  @Override public void acquireWrite()
  {
    while (writers > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    writers++;
    System.out.println("Writers: " + writers);
  }

  @Override public void releaseWrite()
  {
    writers--;
    System.out.println("Writers: " + writers);
    notify();
  }
}
