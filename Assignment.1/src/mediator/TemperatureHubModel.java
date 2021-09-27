package mediator;

import model.temperature.Temperature;
import model.temperature.TemperatureList;
import util.PropertyChangeSubject;

public interface TemperatureHubModel extends PropertyChangeSubject
{
  void addTemperature(String id, double temp);
  void updateTempT0(double temp);
  double getOutsideTemp();

  TemperatureList getTempList0();
  TemperatureList getTempList1();
  TemperatureList getTempList2();

  void radiatorUp();
  void radiatorDown();
  int getRadiatorPower();
}
