package client.model;

import client.networking.Client;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class MsnModelManager implements MsnModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;
  private User user;

  public MsnModelManager(Client client)
  {
    this.client = client;
    this.user = null;
    client.addListener("UserListUpdated", this::onUserListUpdated);
    client.addListener("NewMessage", this::onNewMessage);
    client.addListener("NewUser", this::onNewUser);
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  private void onUserListUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  private void onNewUser(PropertyChangeEvent propertyChangeEvent)
  {
    user = ((User) propertyChangeEvent.getNewValue()).copy();
  }

  @Override public void newUser(String username)
  {
    client.newUser(username);                                                                //CHECK
  }

  @Override public void newMessage(String text, User receiver)
  {
    Message newMessage = new Message(text, user, receiver);
    client.newMessage(newMessage);
  }

  @Override public void userDisconnected()
  {
    client.userDisconnected(user);
  }

  @Override public List<User> getUsers()
  {
    return client.getUsers();
  }

  @Override public User getUser()
  {
    return user;
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
