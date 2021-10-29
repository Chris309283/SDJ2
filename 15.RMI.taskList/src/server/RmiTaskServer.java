package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

public class RmiTaskServer implements RemoteTaskList
{
  private TaskList taskList;

  public RmiTaskServer()
  {
    this.taskList = new TaskList();
  }

  private void startRegistry() throws RemoteException
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

  private void startServer() throws RemoteException, MalformedURLException
  {
    UnicastRemoteObject.exportObject(this,0);
    Naming.rebind("Task",this);
  }

  @Override public void add(Task task) throws RemoteException
  {
    taskList.add(task);
  }

  @Override public Task get() throws RemoteException
  {
    return taskList.getAndRemoveNextTask();
  }

  @Override public int size() throws RemoteException
  {
    return taskList.size();
  }
}
