public class Philosopher implements Runnable
{
  private int id;
  private Fork leftFork;
  private Fork rightFork;
  private int eaten;

  public Philosopher(int id, Fork leftFork, Fork rightFork)
  {
    this.id = id;
    this.leftFork = leftFork;
    this.rightFork = rightFork;
    this.eaten = 0;
  }

  @Override public void run()
  {
   try
   {
     while (true)
     {
        if (id==0|| id == 2 || id == 4)
        {
          doSomeOpr("THINK",1000,1000);
          rightFork.getFork();
          leftFork.getFork();
          doSomeOpr("EAT",5000,5000);
          rightFork.putBack();
          leftFork.putBack();
        }
        else
        {
          doSomeOpr("THINK",1000,1000);
          leftFork.getFork();
          rightFork.getFork();
          doSomeOpr("EAT",5000,5000);
          leftFork.putBack();
          rightFork.putBack();
        }
     }
   }
   catch (Exception e)
   {
     e.printStackTrace();
   }

  }

  private void doSomeOpr(String operation, int min, int max)
  {
    long time = (long) (Math.random()*(max-min)+min);
    try
    {
      System.out.println("Doing " + operation);
      if (operation.equalsIgnoreCase("eat"))
      {
        eaten++;
        System.out.println("phil " + id + " has eaten " +eaten + " times");
      }
      Thread.sleep(time);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
