package client.views.main;

import client.model.MsnModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Message;
import shared.transferobjects.User;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;

public class MainViewModel implements Subject
{
  private final PropertyChangeSupport support = new PropertyChangeSupport(this);
  private MsnModel msnModel;
  private ObservableList<User> users;

  public MainViewModel(MsnModel msnModel)
  {
    this.msnModel = msnModel;
    this.users = FXCollections.observableArrayList(getSortedList());
    msnModel.addListener("UserListUpdated", this::onUserListUpdated);
    msnModel.addListener("NewMessage", this::onNewMessage);
  }

  private void onUserListUpdated(
      PropertyChangeEvent propertyChangeEvent)                                //CHECK
  {
    if (!users.isEmpty())
    {
      users.clear();
      users.addAll(getSortedList());
    }
  }

  private void onNewMessage(PropertyChangeEvent event)
  {
    Message newMessage = (Message) event.getNewValue();
    if (newMessage.getReceiver() != null)
    {
      if (newMessage.getReceiver().equals(msnModel.getUser()))
      {
        support.firePropertyChange("NewTab", null, newMessage);
      }
    }
  }

  private List<User> getSortedList()
  {
    List<User> newList = msnModel.getUsers();
    Collections.sort(newList, (User u1, User u2) -> {
      return u1.getUsername().compareToIgnoreCase(u2.getUsername());
    });
    return newList;
  }

  public ObservableList<User> getUsers()
  {
    return users;
  }

  public void userDisconnected()
  {
    msnModel.userDisconnected();
  }

  public User getUser()
  {
    return msnModel.getUser();
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
