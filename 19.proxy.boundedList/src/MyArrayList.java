import java.util.ArrayList;

public class MyArrayList implements ListADT
{
  private ArrayList<String> list;

  public MyArrayList(ArrayList<String> list)
  {
    this.list = list;
  }

  @Override public void add(String s)
  {

  }

  @Override public void add(int idx, String s)
  {

  }

  @Override public void set(int idx, String s)
  {

  }

  @Override public String get(int idx)
  {
    return null;
  }

  @Override public String remove(int idx)
  {
    return null;
  }

  @Override public String remove(String idx)
  {
    return null;
  }

  @Override public int indexOf(String s)
  {
    return 0;
  }

  @Override public boolean contains(String s)
  {
    return false;
  }

  @Override public boolean isEmpty()
  {
    return false;
  }

  @Override public int size()
  {
    return 0;
  }
}
