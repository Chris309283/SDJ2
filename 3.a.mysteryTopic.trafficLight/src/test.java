public class test
{
  public static void main(String[] args)
  {
    TrafficLight tl1 = new TrafficLight();

    Car car1 = new Car(1);
    Car car2 = new Car(2);
    Car car3 = new Car(3);
    Car car4 = new Car(4);

    tl1.addParticipant(car1);
    tl1.addParticipant(car2);
    tl1.addParticipant(car3);
    tl1.addParticipant(car4);

    Taxi taxi1 = new Taxi(1);
    Taxi taxi2 = new Taxi(2);

    tl1.addParticipant(taxi1);
    tl1.addParticipant(taxi2);

    Pedestrian pedestrian1 = new Pedestrian(1);

    tl1.addParticipant(pedestrian1);

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
