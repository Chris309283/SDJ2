import Deposit.Deposit;
import Deposit.BlockingQueue;

public class TEST
{
  public static void main(String[] args)
  {
    Deposit deposit = new BlockingQueue(10);
   Miner miner = new Miner(deposit);
   ValuableTransporter valuableTransporter = new ValuableTransporter(deposit);

   new Thread(miner).start();
   new Thread(valuableTransporter).start();
  }
}
