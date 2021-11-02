package server;

import shared.RemoteTaskList;

public class ServerApp
{
  public static void main(String[] args) throws Exception
  {
    if (System.getSecurityManager() == null)
    {
      System.setSecurityManager(new SecurityManager());
    }
    RemoteTaskList server = new RmiTaskServer();
  }
}
