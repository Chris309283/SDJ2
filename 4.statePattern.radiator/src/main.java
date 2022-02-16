import java.util.Scanner;

public class main
{
  public static void main(String[] args)
  {
    Radiator r1 = new Radiator(new OffState());
    Scanner input = new Scanner(System.in);

    while (true)
    {
    r1.getPower();
      System.out.println("Radiator");
      System.out.println("Press 1 to turn up");
      System.out.println("Press 2 to turn down");
      int choice = input.nextInt();
      if (choice == 1)
      {
        r1.turnUp();
      }
      else if (choice == 2)
      {
        r1.turnDown();
      }
      else
      {
        System.out.println("invalid choice");
      }
    }


  }
}
