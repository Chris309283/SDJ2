public class Power3State implements RadiatorState
{
  private static final int POWER = 3;
  Thread thread;

  public Power3State(Radiator radiator)
  {
    Runnable runnable = () -> {
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        System.out.println("Power state decreased automatically");
      }
      radiator.setPowerState(new Power2State());
    };
    thread = new Thread(runnable);
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void turnUp(Radiator radiator)
  {

  }

  @Override public void turnDown(Radiator radiator)
  {
    thread.interrupt();
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
