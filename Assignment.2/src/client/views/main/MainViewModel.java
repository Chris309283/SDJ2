package client.views.main;

import client.model.ChatAppModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Message;
import shared.transferobjects.User;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel implements Subject
{
  private final PropertyChangeSupport support = new PropertyChangeSupport(this);
  private ChatAppModel chatAppModel;
  private ObservableList<User> users;

  public MainViewModel(ChatAppModel chatAppModel)
  {
    this.chatAppModel=chatAppModel;
    chatAppModel.addListener("USER LIST MODIFIED", this::onUserListModified);
    chatAppModel.addListener("NEW MESSAGE", this::onNewMessage);
    this.users = FXCollections.observableArrayList(getSortedList());
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    Message newMessage = (Message) propertyChangeEvent.getNewValue();
    if (newMessage.getReceiver() != null && newMessage.getReceiver()
        .equals(chatAppModel.getIdentity()))
    {
      support.firePropertyChange("CREATE NEW TAB", null, newMessage);
    }
  }

  private void onUserListModified(PropertyChangeEvent propertyChangeEvent)
  {
    users.clear();
    users.addAll(getSortedList());
  }

  private List<User> getSortedList()
  {
    List<User> list = chatAppModel.getUsers();
    list.sort((User user1, User user2) -> {
      return user1.getNickName().compareToIgnoreCase(user2.getNickName());
    });
    return list;
  }

  public ObservableList<User> getUsers()
  {
    return users;
  }

  public ObservableList<String> getUsernames()
  {
    ObservableList<String> usernames = null;
    for (int i = 0; i < users.size(); i++)
    {
      usernames.add(users.get(i).getNickName());
    }
    return usernames;
  }

  public User getIdentity() {
    return chatAppModel.getIdentity();
  }

  public void userLeft() {
    chatAppModel.userLeft();
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }
}
