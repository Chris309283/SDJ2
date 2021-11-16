import java.util.concurrent.BlockingQueue;
//producer
public class Reception implements Runnable
{
  private BlockingQueue<Customer> queue;

  public Reception(BlockingQueue<Customer> queue)
  {
    this.queue = queue;
  }

  @Override public void run()
  {
    String[] customers = {"Alfonso", "Vlad", "Simas", "Benjamin", "Chris",
        "Adrian", "Emil", "Joe", "Bob", "Cartman"};
    System.out.println(customers.length + " Customers waiting");
    for (String customerName : customers)
    {
      Customer customer = new Customer(customerName);
      try
      {
        Thread.sleep(1000);
        queue.put(customer);
        System.out.println(customer.getName()+ " is waiting for the hooker");
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
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
