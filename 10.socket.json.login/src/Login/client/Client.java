package Login.client;

import Login.client.model.Model;
import Login.client.model.ModelManager;

import java.io.IOException;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    Model model = new ModelManager();
    boolean running = true;
    while (true)
    {
      System.out.println("Please input your username: ");
      String userName = input.nextLine();
      System.out.println("Please input your password: ");
      String password = input.nextLine();
      model.login(userName, password);

    }
  }
}
