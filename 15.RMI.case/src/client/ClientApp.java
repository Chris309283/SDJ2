package client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientApp
{
  public static void main(String[] args) throws RemoteException
  {
    RmiCaseClient client = new RmiCaseClient();

    Scanner input = new Scanner(System.in);

    System.out.println("Enter a string to convert: ");
    String uppercase = input.nextLine();
    System.out.println(client.convert(uppercase, true));

    System.out.println("Enter a string to convert: ");
    String capitalize = input.nextLine();
    System.out.println(client.convert(capitalize, false));
  }
}
