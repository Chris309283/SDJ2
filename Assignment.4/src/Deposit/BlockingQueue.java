package Deposit;

import Mine.Valuable;

import java.util.ArrayList;

public class BlockingQueue implements Deposit
{
  private final ArrayList<Valuable> queue;
  private final int capacity;

  public BlockingQueue(int capacity)
  {
    this.queue = new ArrayList<>();
    this.capacity = capacity;
  }

  @Override public synchronized void put(Valuable valuable)
  {
    try
    {
      while (queue.size() >= capacity)
      {
        wait();
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    queue.add(valuable);
    notifyAll();
  }

  @Override public synchronized Valuable take()
  {
    try
    {
      while (queue.size() <= 0)
      {
        wait();
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    Valuable valuable = queue.remove(0);
    notifyAll();
    return valuable;
  }

  @Override public synchronized boolean isFull()
  {
    return !queue.isEmpty();
  }

  @Override public synchronized boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public synchronized int size()
  {
    return queue.size();
  }
}
