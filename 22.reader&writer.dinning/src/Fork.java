public class Fork
{
  private int id;
  private boolean isTaken;

  public Fork(int id)
  {
    this.id = id;
  }

  public synchronized void getFork()
  {
    try
    {
      while (isTaken)
      {
        System.out.println(
            "--| " + Thread.currentThread().getName() + " waiting for fork "
                + id);
        wait();
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    isTaken = true;
    System.out.println(
        "--> " + Thread.currentThread().getName() + " took fork " + id);
  }

  public synchronized void putBack()
  {
    isTaken = false;
    System.out.println("<-- " +Thread.currentThread().getName()+ " returned fork "+ id);
    notify();
  }
}
