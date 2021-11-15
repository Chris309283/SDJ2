import java.io.*;

public class FilePersonStorage implements PersonStorage
{

  private final File file;
  private FileWriter fileWriter;

  public FilePersonStorage()
  {
    file = new File("PersonStorage");
    try
    {
      fileWriter = new FileWriter(file, true);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addPerson(Person prsn)
  {
    Person existingPeron = getPerson(prsn.ssn);
    if (existingPeron != null)
      throw new IllegalStateException("Person already exists");

    String toWrite = prsn.ssn + ";" + prsn.name + ";" + prsn.dob + "/n";
    try
    {
      fileWriter.append(toWrite);
      fileWriter.flush();
      fileWriter.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Person getPerson(int ssn)
  {
    BufferedReader bufferedReader;

    try
    {
      bufferedReader = new BufferedReader(new FileReader(file));
      String line = bufferedReader.readLine();
      while (line != null)
      {
        String[] split = line.split(";");
        int tempSSN = Integer.parseInt(split[0]);
        if (ssn == tempSSN)
        {
          return new Person(split[1], tempSSN, split[2]);
        }
        line = bufferedReader.readLine();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
