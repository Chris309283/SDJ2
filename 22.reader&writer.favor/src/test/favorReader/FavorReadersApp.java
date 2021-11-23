package test.favorReader;

import test.ReadWrite;
import test.Reader;
import test.Writer;

public class FavorReadersApp
{
  public static void main(String[] args)
  {
    ReadWrite shared = new FavorReaders();
    Thread[] readers = new Thread[10];
    for (int i = 0; i < readers.length; i++)
    {
      Reader reader = new Reader(shared);
      readers[i] = new Thread(reader, "Reader "+i);
      readers[i].start();
    }

    Thread[] writers = new Thread[2];
    for (int i = 0; i < writers.length; i++)
    {
      Writer writer = new Writer(shared);
      writers[i] = new Thread(writer,"Writer " + i);
      writers[i].start();
    }
    try
    {
      Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.exit(0);
  }
}
