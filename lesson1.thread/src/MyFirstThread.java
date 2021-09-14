public class MyFirstThread extends Thread
{
  private String strParam;

  public MyFirstThread(String strParam)
  {
    this.strParam = strParam;
  }

  public static void main(String[] args)
  {
    MyFirstThread t1 = new MyFirstThread("One");
    t1.start();
    MyFirstThread t2 = new MyFirstThread("Two");
    t2.setDaemon(true);
    t2.start();
    sleepASecond();
    t1.setStrParam("exit");
  }

  private void setStrParam(String strParam)
  {
    this.strParam = strParam;
  }

  @Override public void run()
  {
    while (!"exit".equals(strParam))
    {
      System.out.println(
          (isDaemon() ? "daemon" : "user") + " thread " + this.getName()
              + " [ID=" + this.getId() + "] passed parameter: " + strParam);
      sleepASecond();
    }
    System.out.println(
        (isDaemon() ? "daemon" : "user") + " thread " + this.getName() + " [ID="
            + this.getId() + "] passed parameter: " + strParam);
  }

  public static void sleepASecond()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}