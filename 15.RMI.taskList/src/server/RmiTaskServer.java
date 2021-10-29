package server;

import shared.RemoteTaskList;
import shared.Task;
import shared.TaskList;

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

  public RmiTaskServer() throws RemoteException, MalformedURLException
  {
    this.taskList = new TaskList();
    startRegistry();
    startServer();
    System.out.println("Server is running...");
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
    System.out.println("Adding...");
    taskList.add(task);
  }

  @Override public Task get() throws RemoteException
  {
    System.out.println("Getting...");
    return taskList.getAndRemoveNextTask();
  }

  @Override public int size() throws RemoteException
  {
    System.out.println("Getting size...");
    return taskList.size();
  }
}
