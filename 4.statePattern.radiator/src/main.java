public class main
{
  public static void main(String[] args)
  {
    Radiator r1 = new Radiator(new OffState());
    r1.turnUp();
    r1.getPower();
    r1.turnUp();
    r1.getPower();
    r1.turnUp();
    r1.getPower();
    try
    {
      Thread.sleep(4000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    r1.turnDown();
    r1.getPower();
    r1.turnDown();
    r1.getPower();
    r1.turnDown();
    r1.getPower();

  }
}
