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

  public synchronized void startBaking()
  {

  }

  public synchronized void finishedBaking(String typeOfCookie)
  {
    while (true)
    {

    }
  }

  public synchronized void eat()
  {
    while (jar.size() <= 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + " is eating a cookie");
      jar.remove(0);
    }
  }
}
