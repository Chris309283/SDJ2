import Mine.Valuable;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ValuableTransporter implements Runnable
{
  private ArrayList<Valuable> transportBag;
  private BlockingQueue<Valuable> deposit;

  public ValuableTransporter(BlockingQueue<Valuable> deposit)
  {
    this.deposit = deposit;
    this.transportBag = new ArrayList<>();
  }

  @Override public void run()
  {
    while (true)
    {
      int ranNumber = ThreadLocalRandom.current().nextInt(50, 200 + 1);
      int value = 0;
      do
      {
        Valuable valuable = null;
        try
        {
          valuable = deposit.take();
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        transportBag.add(valuable);
        System.out.println(
            "The Valuable Transporter took a " + valuable.getType() + " worth: "
                + valuable.getValue());
        value += valuable.getValue();
      }
      while (value < ranNumber);
      transportBag.clear();
      System.out.println("The Transporter has lost all the valuables");
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
