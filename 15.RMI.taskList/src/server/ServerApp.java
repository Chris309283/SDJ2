package server;

import shared.RemoteTaskList;

public class ServerApp
{
  public static void main(String[] args) throws Exception
  {
    RemoteTaskList server = new RmiTaskServer();
  }
}
