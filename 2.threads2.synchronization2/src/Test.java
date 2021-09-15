public class Test
{
  public static void main(String[] args)
  {
    BurgerBar burgerBar = new BurgerBar(15);
    BurgerBarEmployee Emp1 = new BurgerBarEmployee("Alfonso",burgerBar);
    BurgerBarEmployee Emp2 = new BurgerBarEmployee("Vlad", burgerBar);
    BurgerBarCustomer Customer1 = new BurgerBarCustomer("Chris",burgerBar,1);
    BurgerBarCustomer Customer2 = new BurgerBarCustomer("Allan",burgerBar,2);
    BurgerBarCustomer Customer3 = new BurgerBarCustomer("Bob",burgerBar,3);
    BurgerBarCustomer Customer4 = new BurgerBarCustomer("Jens",burgerBar,4);
    BurgerBarCustomer Customer5 = new BurgerBarCustomer("Ib",burgerBar,5);

    Thread t1 = new Thread(Emp1);
    Thread t2 = new Thread(Emp2);
    Thread t3 = new Thread(Customer1);
    Thread t4 = new Thread(Customer2);
    Thread t5 = new Thread(Customer3);
    Thread t6 = new Thread(Customer4);
    Thread t7 = new Thread(Customer5);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
  }
}
