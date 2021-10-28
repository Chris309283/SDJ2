package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiMessageServer implements RemoteMessageList
{
  private ArrayList<String> messages;

  public void start() throws RemoteException, MalformedURLException
  {
    UnicastRemoteObject.exportObject(this,0);
    Naming.rebind("addMessage", this);
  }

  @Override public void addMessage(String message) throws RemoteException
  {
    messages.add(message);
  }
}
