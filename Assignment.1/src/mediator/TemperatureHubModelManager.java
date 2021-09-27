package mediator;

import model.radiator.Radiator;
import model.temperature.Temperature;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureHubModelManager implements TemperatureHubModel
{
  private TemperatureList tempList0;
  private TemperatureList tempList1;
  private TemperatureList tempList2;
  private Radiator radiator;
  private double tempOutside;

  private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

  public TemperatureHubModelManager()
  {
    tempList0 = new TemperatureList();
    tempList1 = new TemperatureList();
    tempList2 = new TemperatureList();
    radiator = new Radiator(changeSupport);
  }

  @Override public void addTemperature(String id, double temp)
  {
    Temperature temperature = new Temperature(id, temp);
    if (id.equals("t1Temp"))
    {
      this.tempList1.addTemperature(temperature);
    }
    if (id.equals("t2Temp"))
    {
      this.tempList2.addTemperature(temperature);
    }
    changeSupport.firePropertyChange(temperature.getThermometerId(), null,
        temperature);
  }

  @Override public void updateTempT0(double temp)
  {
    tempOutside = temp;
    changeSupport.firePropertyChange("t0Temp", null,
        new Temperature("t0Temp", temp));
    this.tempList0.addTemperature(new Temperature("t0Temp", temp));
  }

  @Override public double getOutsideTemp()
  {
    return tempOutside;
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

  public TemperatureList getTempList0()
  {
    return tempList0;
  }

  public TemperatureList getTempList1()
  {
    return tempList1;
  }

  public TemperatureList getTempList2()
  {
    return tempList2;
  }
}
