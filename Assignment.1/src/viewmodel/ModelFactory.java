package viewmodel;

import mediator.TemperatureHubModel;
import mediator.TemperatureHubModelManager;

public class ModelFactory
{
private TemperatureHubModel temperatureHubModel;

public TemperatureHubModel getTemperatureHubModel()
{
  if (temperatureHubModel == null)
  {
    temperatureHubModel = new TemperatureHubModelManager();
  }
  return temperatureHubModel;
}
}
