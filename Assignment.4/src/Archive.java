import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Archive
{
  private File logFile;
  private static Archive archive;
  private static final Lock lock = new ReentrantLock();

  private Archive()
  {
    logFile = new File("LogFile.txt");
  }

  public static Archive getInstance()
  {
    if (archive == null)
    {
      synchronized (lock)
      {
        if (archive == null)
        {
          archive = new Archive();
        }
      }
    }
    return archive;
  }

  public void log(String txt)
  {
    try
    {
      System.out.println("Log --> " + txt);
      Writer out = new BufferedWriter(new FileWriter(logFile, true));
      out.append(txt);
      out.flush();
      out.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
