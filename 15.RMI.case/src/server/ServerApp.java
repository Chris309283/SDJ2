package server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class ServerApp
{
  public static void main(String[] args)
      throws RemoteException, MalformedURLException
  {
    //Start the RMI registry
    startRegistry();
    RmiCaseServer server = new RmiCaseServer();
    server.start();
    System.out.println("Server is running...");
  }

  private static void startRegistry() throws RemoteException
  {
    try
    {
      Registry registry = LocateRegistry.createRegistry(1099);
    }
    catch (ExportException ee)
    {
      System.out.println("Registry is already running... " + ee.getMessage());
    }
  }
}
