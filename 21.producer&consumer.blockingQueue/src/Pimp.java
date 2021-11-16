import java.util.concurrent.BlockingQueue;

public class Pimp implements Runnable
{
 private BlockingQueue<Customer> queue;

  public Pimp(BlockingQueue<Customer> queue)
  {
    this.queue = queue;
  }

  @Override public void run()
  {
try
{
  Customer customer = new Customer("");
  while (!customer.getName().equalsIgnoreCase("Receptionist"))
  {
    if (!customer.getName().equalsIgnoreCase("")&&!customer.getName().equalsIgnoreCase("Simas"))
    {
      System.out.println(customer.getName()+ " has gotten a blowjob");
    }
    else if (customer.getName().equalsIgnoreCase("Simas"))
    {
      System.out.println(customer.getName()+ " has gotten a handjob, because his dick was smelly");
    }
    customer = queue.take();
    if (customer != null)
    {
      System.out.println(customer.getName() + " is going in to the hooker");
    }
  }
  System.out.println("All have gotten a blowjob");
}
catch (InterruptedException e)
{
  e.printStackTrace();
}

  }
}
