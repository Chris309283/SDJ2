package mediator;

import model.temperature.Temperature;
import util.PropertyChangeSubject;

public interface TemperatureHubModel extends PropertyChangeSubject
{
  void addTemperature(String id, double temp);
  Temperature getLastInsertedTemperature();
  void updateTempT0(double temp);

  void radiatorUp();
  void radiatorDown();
  int getRadiatorPower();
}
