package temperature.mediator;

import temperature.model.Temperature;
import temperature.model.TemperatureList;

import java.util.ArrayList;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private ArrayList<Listener> listListern;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    listListern = new ArrayList<>();
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
    }
    for (Listener listener : listListern)
    {
      listener.update(temperature);
    }
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void addListener(Listener listener)
  {
    listListern.add(listener);
  }

  @Override public void removeListener(Listener listener)
  {
    listListern.remove(listener);
  }

  // and maybe other methods....
}
