import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Brothel
{
  public static void main(String[] args)
  {
    BlockingQueue<Customer> queue = new ArrayBlockingQueue<>(3);
    Reception producer = new Reception(queue);
    Pimp consumer = new Pimp(queue);

    new Thread(producer).start();
    new Thread(consumer).start();
  }
}
