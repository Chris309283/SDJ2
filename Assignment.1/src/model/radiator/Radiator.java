package model.radiator;

import java.beans.PropertyChangeSupport;

public class Radiator
{
  private RadiatorState currentState;

  private PropertyChangeSupport changeSupport;

  public Radiator(PropertyChangeSupport changeSupport)
  {
    this.currentState = new OffState();
    this.changeSupport = changeSupport;
  }

  public void turnUp()
  {
    currentState.turnUp(this);
  }

  public void turnDown()
  {
    currentState.turnDown(this);
  }

  public int getPower()
  {
    return currentState.getPower();
  }

  void setPowerState(RadiatorState state)
  {
    currentState = state;
    changeSupport.firePropertyChange("radiatorChange", null, getPower());
  }
}
