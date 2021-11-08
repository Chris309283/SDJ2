package server;


import server.model.MsnManagerImpl;
import server.networking.MsnServerImpl;

import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException
  {
    MsnServerImpl msnServer = new MsnServerImpl(new MsnManagerImpl());
    msnServer.startServer();
  }
}
