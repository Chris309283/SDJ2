import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBoundedQueue implements StringQueue
{
  StringQueue queue;
  private final Lock lock = new ReentrantLock();

  public ThreadSafeBoundedQueue(StringQueue queue)
  {
    this.queue = queue;
  }

  @Override public void enqueue(String element)
  {
    synchronized (lock)
    {
      queue.enqueue(element);
    }
  }

  @Override public String dequeue()
  {
    synchronized (lock)
    {
      return queue.dequeue();
    }
  }

  @Override public String first()
  {
    synchronized (lock)
    {
      return queue.first();
    }
  }

  @Override public int size()
  {
    synchronized (lock)
    {
      return queue.size();
    }
  }

  @Override public int indexOf(String element)
  {
    synchronized (lock)
    {
      return queue.indexOf(element);
    }
  }

  @Override public boolean isEmpty()
  {
    synchronized (lock)
    {
      return queue.isEmpty();
    }
  }

  @Override public boolean contains(String element)
  {
    synchronized (lock)
    {
      return queue.contains(element);
    }
  }
}
