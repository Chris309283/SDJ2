public class BurgerBar
{
  private int numberOfBurgers, maxNumberOfBurgers;

  public BurgerBar(int maxNumberOfBurgers)
  {
    this.maxNumberOfBurgers = maxNumberOfBurgers;
    numberOfBurgers = 0;
  }

  public synchronized void makeBurger(String employeeName) throws InterruptedException
  {
    System.out.println("Total burgers ready: " + numberOfBurgers + "/" +maxNumberOfBurgers);
    while (numberOfBurgers >= maxNumberOfBurgers)
    {
      System.out.println("WAITING FOR SOMEONE TO EAT A HAMBURGER");
      wait();
    }
    System.out.println(employeeName + " just finished a burger");
    numberOfBurgers++;
    notifyAll();
  }

  public synchronized void eatBurger(String who) throws InterruptedException
  {
    System.out.println("Burger ready for: " + who);
    System.out.println("Total burgers: " + numberOfBurgers + "/" +maxNumberOfBurgers);
    while (numberOfBurgers <= 0)
    {
      System.out.println("WAITING FOR SOMEONE TO MAKE A HAMBURGER");
      wait();
    }
    System.out.println(who + " is eating a burger (" + numberOfBurgers + " left)");
    numberOfBurgers--;
    notifyAll();
  }

  public int getNumberOfBurgers()
  {
    return numberOfBurgers;
  }
}
