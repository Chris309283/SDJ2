package model.temperature;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * A class representing time with hours, minutes and seconds.
 *
 * @author Java Gods
 * @version 1.0
 */
public class Time implements Serializable
{
  private int hour, minute, second;

  public Time()
  {
    hour = LocalTime.now().getHour();
    minute = LocalTime.now().getMinute();
    second = LocalTime.now().getSecond();
  }

  /**
   * Compares the hour, minute and second of two times
   *
   * @param obj The object to compare this time against.
   * @return true if the given object is equal to this time.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }
    Time other = (Time) obj;

    return hour == other.hour && minute == other.minute
        && second == other.second;
  }

  /**
   * Gives a string representation of the object.
   *
   * @return A string representation of the time in the format hh:mm:ss.
   */
  public String toString()
  {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }
}
