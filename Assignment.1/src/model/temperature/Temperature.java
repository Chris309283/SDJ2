package model.temperature;

public class Temperature
{
  private Time time;
  private String thermometerId;
  private double temp;

  public Temperature(String thermometerId, double temp)
  {
    this.thermometerId = thermometerId;
    this.temp = temp;
    this.time = new Time();
  }

  public String getTime()
  {
    return time.toString();
  }

  public String getThermometerId()
  {
    return thermometerId;
  }

  public double getTemp()
  {
    return temp;
  }
}
