import java.util.Scanner;

public class UIPersonStorage
{
 private PersonStorage storage;

  public UIPersonStorage(PersonStorage storage)
  {
    this.storage = storage;
  }

  public void startUI()
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.println("choose option:");
      System.out.println("1: add person");
      System.out.println("2: get person");

      int choice = in.nextInt();
      if (choice == 1)
      {
        System.out.println("Name?");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("SNN?");
        int snn = in.nextInt();
        in.nextLine();
        System.out.println("Date of birth?");
        String dob = in.nextLine();
        Person toAdd = new Person(name, snn, dob);
        storage.addPerson(toAdd);
      }
      else if (choice == 2)
      {
        System.out.println("SNN?");
        int snn = in.nextInt();
        Person person = storage.getPerson(snn);
        System.out.println(person);
      }
      else
        System.out.println("Invalid Choice");
    }
  }
}
