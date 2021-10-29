package server;

import client.RemoteSender;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiCallbackServer implements RemoteMessageList
{
  private ArrayList<String> messageList;

  public RmiCallbackServer()
  {
    this.messageList = new ArrayList<>();
  }

  public void start() throws RemoteException, MalformedURLException
  {
    UnicastRemoteObject.exportObject(this,0);
    Naming.rebind("addMessage", this);
  }

  @Override public void addMessage(String message, RemoteSender sender)
      throws RemoteException
  {
    messageList.add(message);
    System.out.println(message);
    sender.replyMessage("Thank you");
  }
}
