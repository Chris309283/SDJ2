package client;

import shared.RemoteTaskList;
import shared.Task;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RmiTaskClient
{
  private RemoteTaskList serverStub;

  public RmiTaskClient(String host)
  {
    try
    {
      serverStub = (RemoteTaskList) Naming.lookup(
          "rmi://" + host + ":1099/Task");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void start() throws RemoteException
  {
    Scanner input = new Scanner(System.in);
  while (true)
  {
    System.out.println("1) Add a task");
    System.out.println("2) Get a task");
    System.out.println("3) get task size");
    System.out.println("Any other number) Exit");
    switch (input.nextInt())
    {
      case 1:
        input.nextLine();
        System.out.println("Enter task: ");
        String taskName = input.nextLine();
        System.out.println("Enter estimate: ");
        Long estimate = input.nextLong();
        Task task = new Task(taskName, estimate);
        serverStub.add(task);
        break;
      case 2:
        Task task1 = serverStub.get();
        if (task1!=null)
        {
          System.out.println(task1);
        }
        else
          System.out.println("No Tasks");
        break;
      case 3:
        System.out.println("Task size: "+ serverStub.size());
        break;
      default:
        input.close();
        return;
    }
  }
  }
}
