public class Mailbox implements Runnable
{
  private long maxFrequency;
  private int count;
  private static long RUNTIME = 100000;

  public Mailbox(int count)
  {
    this.count = count;
    maxFrequency = RUNTIME / count;
  }

  private void waitingForMails()
  {
    try
    {
      Thread.sleep(maxFrequency);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {
      System.out.println("New mail in your mailbox...");
      waitingForMails();
    }
  }
}
