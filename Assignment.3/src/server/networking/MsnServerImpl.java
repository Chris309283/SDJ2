package server.networking;

import server.model.MsnManager;
import shared.networking.MsnClient;
import shared.networking.MsnServer;
import shared.transferobjects.Message;
import shared.transferobjects.Request;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MsnServerImpl implements MsnServer
{
  private MsnManager msnManager;

  public MsnServerImpl(MsnManager msnManager) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.msnManager = msnManager;
  }

  public void startServer() throws RemoteException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.rebind("MsnServer", this);
  }

  @Override public User newUser(String username) throws RemoteException
  {
    User newUser = new User(username);
    msnManager.newUser(newUser);
    return newUser;
  }

  @Override public void newMessage(Message message) throws RemoteException
  {
    msnManager.newMessage(message);
  }

  @Override public List<User> getUsers() throws RemoteException
  {
    return msnManager.getUsers();
  }

  @Override public void removeUser(String id) throws RemoteException
  {
    msnManager.removeUser(id);
  }

  @Override public void registerClient(MsnClient client, User user)
      throws RemoteException
  {
    msnManager.addListener("UserListUpdated",
        event -> onUserListUpdate(event, client));
    msnManager.addListener("NewMessage",
        event -> onNewMessage(event, client, user.getId()));
  }

  private void onUserListUpdate(PropertyChangeEvent event, MsnClient client)
  {
    try
    {
      client.update(new Request("UserListUpdated", null));
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  private void onNewMessage(PropertyChangeEvent event, MsnClient client,
      String ID)
  {
    if (((Message) event.getNewValue()).getReceiver() == null)
    {
      try
      {
        client.update(
            new Request(event.getPropertyName(), event.getNewValue()));
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
    else if (((Message) event.getNewValue()).getReceiver().getId().equals(ID)
        || ((Message) event.getNewValue()).getSender().getId().equals(ID))
      try
      {
        client.update(
            new Request(event.getPropertyName(), event.getNewValue()));
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
  }
}
