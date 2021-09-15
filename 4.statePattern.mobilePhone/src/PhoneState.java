public interface PhoneState
{
  public void onReceiveMessage(String txt,Phone phone);
  public void onReceiveCall(Phone phone);
  public void onVolumeButtonUp(Phone phone);
  public void onVolumeButtonDown(Phone phone);
}
