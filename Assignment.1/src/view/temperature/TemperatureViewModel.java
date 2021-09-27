package view.temperature;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import mediator.TemperatureHubModel;
import javafx.application.Platform;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

public class TemperatureViewModel
{
  private TemperatureHubModel model;

  private DoubleProperty t0Temp;
  private DoubleProperty t1Temp;
  private DoubleProperty t2Temp;


  private IntegerProperty radiator;

  public TemperatureViewModel(TemperatureHubModel model)
  {
    this.model = model;
    this.t0Temp = new SimpleDoubleProperty();
    this.t1Temp = new SimpleDoubleProperty();
    this.t2Temp = new SimpleDoubleProperty();

    this.radiator = new SimpleIntegerProperty();
    model.addPropertyChangeListener(this::updateValues);
  }

  private void updateRadiator(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      radiator.setValue((int) evt.getNewValue());
    });
  }

  private void updateTemps(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      Temperature t = (Temperature) evt.getNewValue();
      if (evt.getPropertyName().equals("t0Temp"))
      {
        t0Temp.setValue(t.getTemp());
      }
      if (evt.getPropertyName().equals("t1Temp"))
      {
        t1Temp.setValue(t.getTemp());
      }
      if (evt.getPropertyName().equals("t2Temp"))
      {
        t2Temp.setValue(t.getTemp());
      }
    });
  }

  private void updateValues(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("radiatorChange"))
    {
      updateRadiator(evt);
    }
    else
    {
      updateTemps(evt);
    }
  }

  public DoubleProperty t0TempProperty()
  {
    return t0Temp;
  }

  public DoubleProperty t1TempProperty()
  {
    return t1Temp;
  }

  public DoubleProperty t2TempProperty()
  {
    return t2Temp;
  }

  public IntegerProperty radiatorProperty()
  {
    return radiator;
  }

  public void radiatorUp()
  {
    model.radiatorUp();
  }

  public void radiatorDown()
  {
    model.radiatorDown();
  }
}
