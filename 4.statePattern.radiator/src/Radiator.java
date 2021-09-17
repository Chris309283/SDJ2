public class Radiator
{
  private RadiatorState currentState;

  public Radiator(RadiatorState currentState)
  {
    this.currentState = currentState;
  }

  public void turnUp()
  {
    currentState.turnUp(this);
  }

  public void turnDown()
  {
    currentState.turnDown(this);
  }

  public void getPower()
  {
    System.out.println("Current Power: " + currentState.getPower());
  }

  void setPowerState(RadiatorState state)
  {
   currentState = state;
    System.out.println("Power changed to: "+ state.getPower());
  }
}
