package client.networking;

import shared.networking.MsnClient;
import shared.networking.MsnServer;
import shared.transferobjects.Message;
import shared.transferobjects.Request;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, MsnClient
{
  private MsnServer server;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public RMIClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost",
          1099);
      server = (MsnServer) registry.lookup("MsnServer");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void newUser(String UserName)
  {
    try
    {
      User user = server.newUser(UserName);
      server.registerClient(this, user.copy());
      support.firePropertyChange("NewUser", null, user);
    }
    catch (RemoteException e)
    {
      System.out.println("Can't create user...");
      e.printStackTrace();
    }
  }

  @Override public void newMessage(Message message)
  {
    try
    {
      server.newMessage(message);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<User> getUsers()
  {
    try
    {
      return server.getUsers();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void userDisconnected(User user)
  {
    try
    {
      server.removeUser(user.getId());
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void update(Request request) throws RemoteException
  {
    support.firePropertyChange(request.getType(), null, request.getArg());
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
