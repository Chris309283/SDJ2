package client;

import java.rmi.Naming;

public class RmiTaskClient
{
  private RemoteTaskList serverStub;

  public RmiTaskClient(String host)
  {
    try
    {
      serverStub = (RemoteTaskList) Naming.lookup(
          "rmi://" + host + ":1099/addMessage");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void start()
  {

  }
}
