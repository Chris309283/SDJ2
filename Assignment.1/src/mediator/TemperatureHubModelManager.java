package mediator;

import model.radiator.Radiator;
import model.temperature.Temperature;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureHubModelManager implements TemperatureHubModel
{
  private TemperatureList tempList;
  private Radiator radiator;

  private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

  public TemperatureHubModelManager()
  {
    tempList = new TemperatureList();
    radiator = new Radiator(changeSupport);
  }

  @Override public void addTemperature(String id, double temp)
  {
    Temperature temperature = new Temperature(id, temp);
    Temperature oldTemperature = getLastInsertedTemperature();
    this.tempList.addTemperatures(temperature);
    if (oldTemperature != null && oldTemperature != temperature)
    {
      changeSupport.firePropertyChange(temperature.getThermometerId(),
          oldTemperature.getTemp(), temperature.getTemp());
    }
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return tempList.getLastTemp();
  }

  @Override public void updateTempT0(double temp)
  {
    changeSupport.firePropertyChange("t0Temp", null, temp);
  }

  @Override public void radiatorUp()
  {
    radiator.turnUp();
  }

  @Override public void radiatorDown()
  {
    radiator.turnDown();
  }

  @Override public int getRadiatorPower()
  {
    return radiator.getPower();
  }

  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName.equals("") || eventName == null)
    {
      addPropertyChangeListener(listener);
    }
    else
    {
      changeSupport.addPropertyChangeListener(eventName, listener);
    }
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    changeSupport.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName.equals("") || eventName == null)
    {
      removePropertyChangeListener(listener);
    }
    else
    {
      changeSupport.addPropertyChangeListener(eventName, listener);
    }
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    changeSupport.removePropertyChangeListener(listener);
  }
}
