package external;

import view.TemperatureViewController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable
{
  private DateTimeFormatter timeFormatter;
  private TemperatureViewController controller;

  public RunnableClock(TemperatureViewController controller)
  {
    this.controller=controller;
  }

  @Override public void run()
  {
    while (true)
    {
      LocalTime time = LocalTime.now();

      timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      String timeString = time.format(timeFormatter);
      System.out.println(timeString);
      controller.showTime(timeString);
      sleepASecond();
    }
  }

  public static void sleepASecond()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
