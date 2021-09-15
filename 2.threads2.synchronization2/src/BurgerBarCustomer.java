public class BurgerBarCustomer implements Runnable
{
  private String name;
  private BurgerBar burgerBar;
  private int burgersToEat;

  public BurgerBarCustomer(String name, BurgerBar burgerBar, int burgersToEat)
  {
    this.name = name;
    this.burgerBar = burgerBar;
    this.burgersToEat = burgersToEat;
  }

  @Override public void run()
  {
    for (int i = 0; i < burgersToEat; i++)
    {
      try
      {
        burgerBar.eatBurger(name);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      try
      {
        Thread.sleep(1500);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
