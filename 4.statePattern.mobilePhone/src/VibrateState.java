public class VibrateState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone)
  {
    phone.vibrate();
    phone.lightUpScreen();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone)
  {
    phone.vibrate();
    phone.lightUpScreen();
  }

  @Override public void onVolumeButtonUp(Phone phone)
  {
    int vol = phone.getVolume();
    if (vol < 100)
    {
      phone.turnVolumeUp();
    }
  }

  @Override public void onVolumeButtonDown(Phone phone)
  {
    int vol = phone.getVolume();
    if (vol > 1)
    {
      phone.turnVolumeDown();
    }
  }
}
