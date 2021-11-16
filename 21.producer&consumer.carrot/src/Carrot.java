public class Carrot
{
private String id;

  public Carrot(String id)
  {
    this.id = id;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  @Override public String toString()
  {
    return "carrot{" + "id='" + id + '\'' + '}';
  }
}
