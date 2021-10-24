package client.views.chat;

import client.model.ChatAppModel;
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
  private ChatAppModel chatAppModel;
  private StringProperty message;
  private User receiver;

  public ChatTabModel(ChatAppModel chatAppModel)
  {
   this.chatAppModel=chatAppModel;
    this.message = new SimpleStringProperty("");

    chatAppModel.addListener("NEW MESSAGE", this::onNewMessage);
  }
  private void onNewMessage(PropertyChangeEvent event) {
    support.firePropertyChange(event);
  }



  public void sendMessage(String text, User receiver) {
    this.receiver = receiver;
    System.out.println(receiver);
    System.out.println(text);
    chatAppModel.newMessage(text, receiver);
  }


  @Override
  public void addListener(String evt, PropertyChangeListener listener) {
    support.addPropertyChangeListener(evt, listener);
  }

  @Override
  public void removeListener(String evt, PropertyChangeListener listener) {
    support.removePropertyChangeListener(evt, listener);

  }

  public User getIdentity() {
    return chatAppModel.getIdentity();
  }
}
