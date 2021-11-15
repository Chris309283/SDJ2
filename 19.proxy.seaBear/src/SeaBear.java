public class SeaBear implements VisitSeaBear
{

  @Override public void view(String personType)
  {
    System.out.println(personType + "is watching the sea bear intensely");
  }

  @Override public void feed(String personType)
  {
    System.out.println(personType + " is feeding the sea bear aggressively");
  }

  @Override public void pet(String personType)
  {
    System.out.println(personType + " is petting the sea bear vigorously");
  }
}
