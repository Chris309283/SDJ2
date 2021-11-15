import java.util.ArrayList;

public class Queue implements StringQueue
{
  private ArrayList<String> list;

  public Queue()
  {
    list = new ArrayList<>();
  }

  @Override public void enqueue(String element)
  {
    list.add(element);
  }

  @Override public String dequeue()
  {
    if (list.isEmpty()) throw new IllegalStateException("List is empty");
    return list.remove(0);
  }

  @Override public String first()
  {
    if (list.isEmpty()) throw new IllegalStateException("List is empty");
    return list.get(0);
  }

  @Override public int size()
  {
    return list.size();
  }

  @Override public int indexOf(String element)
  {
    return list.indexOf(element);
  }

  @Override public boolean isEmpty()
  {
    return list.isEmpty();
  }

  @Override public boolean contains(String element)
  {
    return list.contains(element);
  }
}
