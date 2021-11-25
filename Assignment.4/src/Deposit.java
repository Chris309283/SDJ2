import Mine.Valuable;

import java.util.ArrayList;

public class Deposit
{
  private final ArrayList<Valuable> list;

  public Deposit()
  {
    this.list = new ArrayList<>();
  }

  public void enqueue(Valuable element)
  {
    list.add(element);
  }

  public Valuable dequeue()
  {
    if (list.isEmpty()) throw new IllegalStateException("List is empty");
    return list.remove(0);
  }

  public Valuable first()
  {
    if (list.isEmpty()) throw new IllegalStateException("List is empty");
    return list.get(0);
  }

  public int size()
  {
    return list.size();
  }
}
