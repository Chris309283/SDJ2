package server.model.login;

import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class LoginModelManager implements LoginModel
{
  private List<User> users = new ArrayList<>();
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  @Override public synchronized void newUser(User user)
  {
    users.add(user);
    support.firePropertyChange("USER LIST MODIFIED", null, null);
  }

  @Override public synchronized List<User> getUsers()
  {
    return users;
  }

  @Override public synchronized void removeUser(User user)
  {
    users.remove(user);
    support.firePropertyChange("USER LIST MODIFIED", null, null);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }
}
