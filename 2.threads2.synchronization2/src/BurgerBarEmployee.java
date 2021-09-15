public class BurgerBarEmployee implements Runnable
{
  private String name;
  private BurgerBar burgerBar;

  public BurgerBarEmployee(String name, BurgerBar burgerBar)
  {
    this.name = name;
    this.burgerBar = burgerBar;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        burgerBar.makeBurger(name);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
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
}
