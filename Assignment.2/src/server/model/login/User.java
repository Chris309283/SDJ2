package server.model.login;

public class User
{
  private UserName userName;
  private Password password;
  private MyDate registrationDate;
  private Time registrationTime;

  public User(UserName userName, Password password)
  {
    if (userName == null || password == null)
    {
      throw new IllegalArgumentException("Null username or password");
    }
    this.userName = userName;
    this.password = password;
    this.registrationDate = new MyDate();
    this.registrationTime = new Time();
  }

  public String toString()
  {
    return userName + ", password = " + password + ", " + registrationDate +" " + registrationTime;
  }

  public UserName getUserName()
  {
    return userName;
  }

  public Password getPassword()
  {
    return password;
  }

  public MyDate getRegistrationDate()
  {
    return registrationDate;
  }

  public Time getRegistrationTime()
  {
    return registrationTime;
  }
}
