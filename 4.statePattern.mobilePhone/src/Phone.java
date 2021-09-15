public class Phone
{
  private PhoneState currentState = new SoundState();
  private int currentVolume;

  public Phone()
  {
  }

  public void receiveMessage(String txt)
  {
    currentState.onReceiveMessage(txt, this);
  }

  public void receiveCall()
  {
    currentState.onReceiveCall(this);
  }

  public void volumeUpButton()
  {
    currentState.onVolumeButtonUp(this);
  }

  public void volumeDownButton()
  {
    currentState.onVolumeButtonDown(this);
  }

  public void goToSilent()
  {
    currentState = new SilentState();
  }

  public void goToVibrate()
  {
    currentState = new VibrateState();
  }

  public void goToSound()
  {
    currentState = new SoundState();
  }

  void turnVolumeUp()
  {
    currentVolume++;
  }

  void turnVolumeDown()
  {
    currentVolume--;
  }

  void playRingTone()
  {
    System.out.println("Ringeling Ringeling");
  }

  void vibrate()
  {
    System.out.println("Brrrrr!");
  }

  void lightUpScreen()
  {
    System.out.println("Screen lights up");
  }

  void beepBeep()
  {
    System.out.println("Beep Beep!");
  }

  int getVolume()
  {
    return currentVolume;
  }

  void setState(PhoneState state)
  {
    currentState = state;
  }
}


