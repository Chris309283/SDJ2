package temperature.mediator;

import temperature.model.Temperature;

public interface TemperatureModel extends Subject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
