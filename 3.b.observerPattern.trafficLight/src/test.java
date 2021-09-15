public class test
{
  public static void main(String[] args)
  {
    TrafficLight tl1 = new TrafficLight();

    Car1 car1 = new Car1();
    Car2 car2 = new Car2(tl1);
    Car3 car3 = new Car3(tl1);
    Car4 car4 = new Car4(tl1);
    tl1.addPropertyChangeListener("LightChanged",car1);

    try
    {
      tl1.start();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

  }
}
