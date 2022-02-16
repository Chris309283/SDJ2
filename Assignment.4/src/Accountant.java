public class Accountant implements Runnable
{
  private TreasureRoomDoor treasure;
  private String name;

  public Accountant(String name, TreasureRoomDoor treasure )
  {
    this.treasure = treasure;
    this.name = name;
  }

  @Override public void run()
  {
    Thread.currentThread().setName(name);
    Archive archive = Archive.getInstance();

    try
    {
      while (true)
      {
        treasure.acquiredRead();
        archive.log("_________________________________>Counting treasure...");
        Thread.sleep(500);
        archive.log("_________________________________>Treasure add up to: " + treasure.look(this));
        treasure.releaseRead();
        Thread.sleep(1000);
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
