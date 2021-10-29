package client;

import server.RemoteMessageList;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiMessageClient
{
  private RemoteMessageList serverStub;

  public RmiMessageClient()
  {
    try
    {
      serverStub = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void send(String text) throws RemoteException
  {
    serverStub.addMessage(text);
  }

}
