package test;

public class Reader implements Runnable
{
  private ReadWrite lock;

  public Reader(ReadWrite lock)
  {
    this.lock = lock;
  }

  @Override public void run()
  {
    doSomeOpr("PREP",1000,2000);
    lock.acquireRead();
    doSomeOpr("PREP",1000,4000);
    lock.releaseRead();
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
