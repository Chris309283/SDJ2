package server.model.chat;

import shared.transferobjects.Message;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatModelManager implements ChatModel
{
  PropertyChangeSupport support = new PropertyChangeSupport(this);

  @Override public void newMessage(Message message)
  {
    support.firePropertyChange("NEW MESSAGE", null, message);
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
