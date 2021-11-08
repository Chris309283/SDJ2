package shared.transferobjects;

import java.io.Serializable;

public class User implements Serializable
{
  private String username, ip, id;

  public User(String username)
  {
    this.username = username;
    this.ip = "0.0.0.0";
    this.id = "ID#" + ip.replace(".", "") + (int) (username.hashCode()
        * Math.random());
  }

  public User(String username, String ip)
  {
    this.username = username;
    this.ip = ip;
    this.id = "ID#" + ip.replace(".", "") + (int) (username.hashCode()
        * Math.random());
  }

  public User(String username, String ip, String id)
  {
    this.username = username;
    this.ip = ip;
    this.id = id;
  }

  public String getUsername()
  {
    return username;
  }

  public String getIp()
  {
    return ip;
  }

  public String getId()
  {
    return id;
  }

  public User copy()
  {
    return new User(username, ip, id);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof User))
    {
      return false;
    }
    User other = (User) obj;
    return username.equals(other.username) && ip.equals(other.ip) && id.equals(
        other.id);
  }

  @Override public String toString()
  {
    return username;
  }
}


