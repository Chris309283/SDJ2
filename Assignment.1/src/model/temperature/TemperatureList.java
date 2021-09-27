package model.temperature;

import java.util.ArrayList;
import java.util.List;

public class TemperatureList
{
  private ArrayList<Temperature> temperatures;

  public TemperatureList()
  {
    temperatures = new ArrayList<>();
  }

  public void addTemperature(Temperature temp)
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

  public int getSize()
  {
    return temperatures.size();
  }

  public Temperature get(int index)
  {
    return temperatures.get(index);
  }

  public List<Temperature> getList()
  {
    List<Temperature> list = new ArrayList<Temperature>(temperatures);
    return list;
  }
}
