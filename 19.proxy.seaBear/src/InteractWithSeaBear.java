public class InteractWithSeaBear
{
  public static void main(String[] args)
  {
    VisitSeaBear sbg = new SeaBearGuard(new SeaBear());

    sbg.feed("Child");
    sbg.feed("Adult");
    sbg.feed("ZooKeeper");
    sbg.pet("Adult");
    sbg.pet("Child");
    sbg.view("Child");
    sbg.view("Adult");
  }
}
