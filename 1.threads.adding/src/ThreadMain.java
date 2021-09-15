import java.util.ArrayList;

public class ThreadMain
{
  public static void main(String[] args)
  {
    ArrayList<String> list = new ArrayList<>();

    Runnable myRunnable1 = new Adding("1",1000,list);
    Thread t1 = new Thread(myRunnable1);
   Runnable myRunnable2 = new Adding("2",1000,list);
    Thread t2 = new Thread(myRunnable2);
    Runnable myRunnable3 = new Adding("3",1000,list);
    Thread t3 = new Thread(myRunnable3);

    // Adding a1 = new Adding("1",1500,list);

    t1.start();
    t2.start();
    t3.start();



/*   try
    {
      t1.join();

    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }*/
  }

}
