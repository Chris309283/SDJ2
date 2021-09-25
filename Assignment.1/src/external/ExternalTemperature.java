package external;

import mediator.TemperatureHubModel;

public class ExternalTemperature implements Runnable
{
  private double t,min,max;
  private TemperatureHubModel model;

  public ExternalTemperature(TemperatureHubModel model,double t, double min, double max
      )
  {
    this.t = t;
    this.min = min;
    this.max = max;
    this.model = model;
  }

  /**
   * Calculating the external temperature.
   * Values are only valid if the temperature is being measured
   * approximately every 10th second.
   *
   * @param t0  the last measured external temperature
   * @param min a lower limit (may temporally be deceeded)
   * @param max an upper limit (may temporally be exceeded)
   * @return an updated external temperature
   */
  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  @Override public void run()
  {
    while (true)
    {
      t= externalTemperature(t,min,max);
      model.updateTempT0(t);
      try
      {
        Thread.sleep(4000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
