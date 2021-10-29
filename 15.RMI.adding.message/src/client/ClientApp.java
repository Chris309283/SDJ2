package client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientApp
{
  public static void main(String[] args) throws RemoteException
  {
    RmiMessageClient client = new RmiMessageClient();

    Scanner input = new Scanner(System.in);
    String message;
    do
    {
      System.out.println("Add a message: ");
      message = input.nextLine();
      client.send(message);
    } while (!message.equals("EXIT"));
  }
}
