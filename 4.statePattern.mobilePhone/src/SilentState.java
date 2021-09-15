public class SilentState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone)
  {
   phone.lightUpScreen();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone)
  {
    phone.lightUpScreen();
  }

  @Override public void onVolumeButtonUp(Phone phone)
  {
    int vol = phone.getVolume();
    if (vol < 1)
    {
      phone.setState(new SoundState());
    }
  }

  @Override public void onVolumeButtonDown(Phone phone)
  {
    int vol = phone.getVolume();
    if (vol>1)
    {
      phone.turnVolumeDown();
    }
  }
}
