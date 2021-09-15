public class Counter
{
  private long value;

  public Counter()
  {

  }
/*
  public void increment()
  {
    value++;
  }

  public long getValue()
  {
    return value;
  }
 */


  // method synchronized
  /*
public synchronized void increment()
{
  value++;
}

  public synchronized long getValue()
  {
    return value;
  }
   */

  public void increment()
  {
    synchronized (this)
    { // synchronized on the Counter object
      value++;
    }
  }

  public long getValue()
  {
    synchronized (this)
    {
      return value;
    }
  }


}
