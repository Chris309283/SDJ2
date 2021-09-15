public class Program implements Runnable
{
  private String program;
  private long maxFrequency;
  private String action;
  private int count;
  private static final long RUNTIME = 100000;

  public Program(String program, String action, int count)
  {
    this.program = program;
    this.action = action;
    this.count = count;
    this.maxFrequency = RUNTIME / count;
  }

  private void normalOperation()
  {
    try
    {
      Thread.sleep(maxFrequency);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {
      System.out.println(program + " wants to " + action);
      normalOperation();
    }
  }
}
