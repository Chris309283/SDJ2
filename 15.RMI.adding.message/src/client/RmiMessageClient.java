package client;

import server.RemoteMessageList;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiMessageClient
{
  private RemoteMessageList serverStub;

  public RmiMessageClient()
  {
    try
    {
      serverStub = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/addingMessage");
    }
    catch (NotBoundException e)
    {
      e.printStackTrace();
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public void addMessage(String message) throws RemoteException
  {
    serverStub.addMessage(message);
  }
}
