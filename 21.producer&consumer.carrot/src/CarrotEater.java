import java.util.concurrent.BlockingQueue;

public class CarrotEater implements Runnable
{
  private BlockingQueue<Carrot> queue;

  public CarrotEater(BlockingQueue<Carrot> queue)
  {
    this.queue = queue;
  }

  @Override public void run()
  {
   try
   {
     while (true)
     {
       Carrot carrot = queue.take();
       System.out.println("Bunch size: " + queue.size());
       eatCarrot(carrot);
     }
   }
   catch (InterruptedException e)
   {
     e.printStackTrace();
   }
  }

  private void eatCarrot(Carrot carrot)
  {
    try
    {
      Thread.sleep(200);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.println("Eating Carrot: " + carrot.getId());
  }
}
