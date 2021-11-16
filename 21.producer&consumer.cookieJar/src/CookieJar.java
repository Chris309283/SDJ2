import java.util.ArrayList;

public class CookieJar
{
  private ArrayList<Cookie> jar;
  private int traySize;

  public CookieJar(int traySize)
  {
    this.jar = new ArrayList<>();
    this.traySize = traySize;
  }

  public void startBaking(String type)
  {
    try
    {
      wait(5000);
      finishedBaking(type);
      System.out.println("Started baking " + type + " cookies!");
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  private void finishedBaking(String type)
  {
    for (int i = 0; i < traySize; i++)
    {
      jar.add(new Cookie(type));
    }
    System.out.println("Cookies " + type + " put in the jar!");
  }

  public void eat()
  {
    if (!jar.isEmpty())
    {
      jar.remove(0);
      System.out.println("Eating Cookie!");
    }
  }
}
