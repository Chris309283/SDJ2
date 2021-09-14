public class Taxi implements TrafficLightParticipant
{
  private int id;

  public Taxi(int id)
  {
    this.id = id;
  }

  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
    {
      System.out.println("Taxi " + id + " drives super fast");
    }
    else if ("RED".equals(currentLight))
    {
      System.out.println("Taxi " + id + " stops with screething tires");
    }
  }
}
