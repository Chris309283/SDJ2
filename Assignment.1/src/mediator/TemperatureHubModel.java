package mediator;

import model.temperature.Temperature;
import model.temperature.TemperatureList;
import util.PropertyChangeSubject;

public interface TemperatureHubModel extends PropertyChangeSubject
{
  void addTemperature(String id, double temp);
  Temperature getLastInsertedTemperature(String id);
  void updateTempT0(double temp);


   TemperatureList getTempList0();

  void radiatorUp();
  void radiatorDown();
  int getRadiatorPower();
}
