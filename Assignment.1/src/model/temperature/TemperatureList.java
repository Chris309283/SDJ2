package model.temperature;

import java.util.ArrayList;

public class TemperatureList
{
  private ArrayList<Temperature> temperatures;

  public TemperatureList()
  {
    temperatures = new ArrayList<>();
  }

  public void addTemperatures(Temperature temp)
  {
    if (temperatures.size()>=20)
    {
      temperatures.remove(0);
    }
    temperatures.add(temp);
  }

  public Temperature getLastTemp()
  {
    if (temperatures.size()<1)
    {
      return null;
    }
    else
    {
      return temperatures.get(temperatures.size()-1);
    }
  }
}
