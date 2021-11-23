package test;

public class Writer implements Runnable
{
  private ReadWrite lock;

  public Writer(ReadWrite lock)
  {
    this.lock = lock;
  }

  @Override public void run()
  {
   while (true)
   {
     doSomeOpr("PREP",1000,2000);
     lock.acquireWrite();
     doSomeOpr("PREP",1000,4000);
     lock.releaseWrite();
   }
  }

  private void doSomeOpr(String operation, int min, int max)
  {
    long time = (long) (Math.random()*(max-min)+min);
    try
    {
      System.out.println("Doing " + operation);
      Thread.sleep(time);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
