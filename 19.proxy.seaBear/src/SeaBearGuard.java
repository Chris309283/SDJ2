public class SeaBearGuard implements VisitSeaBear
{
  private SeaBear seaBear;

  public SeaBearGuard(SeaBear seaBear)
  {
    this.seaBear = seaBear;
  }

  @Override public void view(String personType)
  {
    seaBear.view(personType);
  }

  @Override public void feed(String personType)
  {
    if (personType.equalsIgnoreCase("zooKeeper"))
    {
      seaBear.feed(personType);
    }
    else
      System.out.println("only pros may feed the sea bear");
  }

  @Override public void pet(String personType)
  {
    if (personType.equalsIgnoreCase("Child"))
    {
      seaBear.pet(personType);
    }
    else
      System.out.println("You may not pet the sea bear");
  }
}
