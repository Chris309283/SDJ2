package client.networking;

import shared.transferobjects.Message;
import shared.transferobjects.Request;
import shared.transferobjects.User;
import shared.util.Connection;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  public SocketClient()
  {
    this.support = new PropertyChangeSupport(this);
  }

  @Override public void startClient(User user)
  {
    try
    {
      Socket socket = new Socket(Connection.HOST, Connection.PORT);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      new Thread(() -> listenToServer(user, outToServer, inFromServer)).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(User user, ObjectOutputStream outToServer,
      ObjectInputStream inFromServer)
  {
    try
    {
      outToServer.writeObject(new Request("LISTENER", user.getID()));
      while (true)
      {
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.getType(), null, request.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void newUser(String username)
  {
    try
    {
      Request response = request("NEW USER", username);
      support.firePropertyChange("NEW USER", null, response.getArg());
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }

  @Override public void newMessage(Message message)
  {
    try
    {
      Request response = request("NEW MESSAGE", message);
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void userDisconnected(User identity)
  {
    try
    {
      Request response = request("USER LEFT", identity);
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<User> getUsers()
  {
    try
    {
      Request response = request("GET USERS", null);
      return (List<User>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }



  private Request request(String type, Object arg)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket(Connection.HOST, Connection.PORT);
    ObjectOutputStream outToServer = new ObjectOutputStream(
        socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(
        socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    return (Request) inFromServer.readObject();
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
