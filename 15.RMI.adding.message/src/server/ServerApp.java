package server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerApp
{
  public static void main(String[] args)
      throws MalformedURLException, RemoteException
  {
    startRegistry();
    RmiMessageServer server = new RmiMessageServer();
    server.start();
    System.out.println("Server is Running...");
  }

  private static void startRegistry()
  {
    try
    {
      Registry registry = LocateRegistry.createRegistry(1099);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
