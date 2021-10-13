package server.model.chat;

public class Message
{
  private String id;
  private String message;
  private MyDate date;
  private Time time;

  public Message(String id, String message)
  {
    this.id = id;
    this.message = message;
    this.date = new MyDate();
    this.time = new Time();
  }

  public String getId()
  {
    return id;
  }

  public String getMessage()
  {
    return message;
  }

  public MyDate getDate()
  {
    return date;
  }

  public Time getTime()
  {
    return time;
  }

  @Override public String toString()
  {
    return "Message{" + "id='" + id + '\'' + ", message='" + message + '\''
        + ", date=" + date + ", time=" + time + '}';
  }
}
