import Deposit.Deposit;
import Mine.Valuable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ValuableTransporter implements Runnable
{
  private ArrayList<Valuable> transportBag;
  private Deposit deposit;

  public ValuableTransporter(Deposit deposit)
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
        catch (Exception e)
        {
          e.printStackTrace();
        } transportBag.add(valuable);
        System.out.println(
            "The Valuable Transporter took a " + valuable.getType() + " worth: "
                + valuable.getValue());
        value += valuable.getValue();
      }
      while (value < ranNumber);
      System.out.println("The Transporter took valuables worth: " + value);
      transportBag.clear();
      System.out.println("The Transporter has lost all the valuables");
      try
      {
        Thread.sleep(10000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
