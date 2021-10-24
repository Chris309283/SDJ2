package client.model;

import client.networking.Client;
import shared.transferobjects.Message;
import shared.transferobjects.User;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatAppModelManager implements ChatAppModel
{
  private PropertyChangeSupport support;
  private Client client;
  private User identity;

  public ChatAppModelManager(Client client) {
    this.client = client;
    this.support = new PropertyChangeSupport(this);
    identity = null;
    client.addListener("USER LIST MODIFIED", this::onUserListModified);
    client.addListener("NEW MESSAGE", this::onNewMessage);
    client.addListener("NEW USER", this::onNewUser);
  }

  private void onUserListModified(PropertyChangeEvent event) {
    support.firePropertyChange(event);
  }

  private void onNewUser(PropertyChangeEvent event) {
    identity = ((User) event.getNewValue()).copy();
  }

  private void onNewMessage(PropertyChangeEvent event) {
    support.firePropertyChange(event);
  }


  @Override
  public List<User> getUsers() {
    return client.getUsers();
  }

  @Override
  public void userLeft() {
    client.userDisconnected(identity);
  }

  @Override
  public void newUser(String nickName) {
    client.newUser(nickName);
    client.startClient(identity);
  }

  @Override
  public void newMessage(String text, User receiver) {
    Message newMessage = new Message(text, identity, receiver);
    client.newMessage(newMessage);
  }

  public User getIdentity() {
    return identity;
  }


  @Override
  public void addListener(String evt, PropertyChangeListener listener) {
    support.addPropertyChangeListener(evt, listener);
  }

  @Override
  public void removeListener(String evt, PropertyChangeListener listener) {
    support.removePropertyChangeListener(evt, listener);

  }
}
