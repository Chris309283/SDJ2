import java.util.ArrayList;

public class Adding implements Runnable
{
  private String id;
  private long sleepTime;
  private ArrayList<String> list;

  public Adding(String id, long sleepTime, ArrayList<String> list)
  {
    this.id = id;
    this.sleepTime = sleepTime;
    this.list = list;
  }

  @Override public void run()
  {
    for (int i = 0; i < 5; i++)
    {
      list.add(this.id+"#"+i);
      System.out.println(id + " " +list);
      sleepASecond();
    }
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
