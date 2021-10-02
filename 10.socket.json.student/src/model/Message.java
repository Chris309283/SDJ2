package model;

public class Message
{
  private String message;
  private Student student;

  public Message(String message)
  {
    this.message = message;
  }

  public Message(String message, Student student)
  {
    this.message = message;
    this.student = student;
  }

  public String getMessage()
  {
    return message;
  }

  public Student getStudent()
  {
    return student;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  @Override public String toString()
  {
    return "Message{" + "message='" + message + '\'' + ", student=" + student
        + '}';
  }
}
