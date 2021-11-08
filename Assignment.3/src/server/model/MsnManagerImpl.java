package server.model;

import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class MsnManagerImpl implements MsnManager
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private List<User> users;

  public MsnManagerImpl()
  {
    this.users = new ArrayList<>();
  }

  @Override public synchronized void newUser(User user)
  {
    users.add(user);
    support.firePropertyChange("UserListUpdated", null, null);
  }

  @Override public List<User> getUsers()
  {
    return users;
  }

  @Override public synchronized void removeUser(String id)
  {
    users.removeIf(user -> user.getId().equals(id));
    support.firePropertyChange("UserListUpdated", null, null);
  }

  @Override public void newMessage(Message message)
  {
    support.firePropertyChange("NewMessage", null, message);
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
