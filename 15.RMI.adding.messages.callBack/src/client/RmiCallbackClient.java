package client;

import server.RemoteMessageList;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiCallbackClient implements RemoteSender
{
  private RemoteMessageList serverStub;

  public RmiCallbackClient() throws RemoteException, MalformedURLException
  {
    UnicastRemoteObject.exportObject(this,0);
    Naming.rebind("replyMessage",this);

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
    serverStub.addMessage(text,this);
  }


  @Override public void replyMessage(String message) throws RemoteException
  {
    System.out.println(message);
  }
}
