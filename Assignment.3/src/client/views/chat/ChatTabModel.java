package client.views.chat;

import client.model.MsnModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.User;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatTabModel implements Subject
{
  private final PropertyChangeSupport support = new PropertyChangeSupport(this);
  private MsnModel msnModel;
  private StringProperty message;
  private User receiver;

  public ChatTabModel(MsnModel msnModel)
  {
    this.msnModel = msnModel;
    this.message = new SimpleStringProperty("");

    msnModel.addListener("NewMessage", this::onNewMessage);
  }

  private void onNewMessage(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  public void sendMessage(String text, User receiver)
  {
    this.receiver = receiver;
    msnModel.newMessage(text, receiver);
  }

  @Override public void addListener(String evt, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(evt, listener);
  }

  @Override public void removeListener(String evt,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(evt, listener);

  }

  public User getUser()
  {
    return msnModel.getUser();
  }
}
