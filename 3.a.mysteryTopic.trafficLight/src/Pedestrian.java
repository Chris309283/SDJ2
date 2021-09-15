public class Pedestrian implements TrafficLightParticipant
{
  private int id;

  public Pedestrian(int id)
  {
    this.id = id;
  }

  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
    {
      System.out.println("Pedestrian " + id + " waits");
    }
    else if ("RED".equals(currentLight))
    {
      System.out.println("Pedestrian " + id + " walks");
    }

  }

}
