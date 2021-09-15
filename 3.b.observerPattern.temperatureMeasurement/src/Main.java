public class Main
{
  public static void main(String[] args)
  {
    Thermometer tm1 = new Thermometer("t1",15,1);
    Thermometer tm2 = new Thermometer("t2",15,7);

    new Thread(tm1).start();
    new Thread(tm2).start();
  }
}
