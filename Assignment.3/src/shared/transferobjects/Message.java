package shared.transferobjects;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable
{
  private String message;
  private User sender, receiver;
  private LocalDateTime dateTime = LocalDateTime.now();
  private boolean isPrivate;

  public Message(String message, User sender, User receiver)
  {
    this.message = message;
    this.sender = sender;
    this.receiver = receiver;
    this.isPrivate = false;
  }

  public Message(String message, User sender)
  {
    this.message = message;
    this.sender = sender;
    this.receiver = null;
    this.isPrivate = true;
  }

  public String getMessage()
  {
    return message;
  }

  public User getSender()
  {
    return sender;
  }

  public User getReceiver()
  {
    return receiver;
  }

  public LocalDateTime getDateTime()
  {
    return dateTime;
  }

  public boolean isPrivate()
  {
    return isPrivate;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Message))
    {
      return false;
    }
    Message other = (Message) obj;
    return (message.equals(other.message) && sender.equals(other.sender)
        && receiver.equals(other.receiver) && dateTime.equals(other.dateTime));
  }

  @Override public String toString()
  {
    return "Message{" + "message='" + message + '\'' + ", sender=" + sender
        + ", receiver=" + receiver + ", dateTime=" + dateTime + '}';
  }
}
