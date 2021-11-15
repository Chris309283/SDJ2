public class BoundedArrayQueue implements StringQueue {

  private String[] q;
  private int front, count;
  private int cap;

  public BoundedArrayQueue(int cap) {

    this.cap = cap;
  }

  @Override
  public void enqueue(String element) throws IllegalArgumentException, IllegalStateException{
    if(q == null) {
      q = (String[])(new Object[cap]);
    }

    if(element == null) {
      throw new IllegalArgumentException("Null is not allowed");
    } else if(count == cap) {
      throw new IllegalStateException("Queue is full");
    }

    q[(front + count) % cap] = element;
    count++;
  }

  @Override
  public String dequeue() throws IllegalStateException {
    if(count == 0) {
      throw new IllegalStateException("Queue is empty");
    }
    String tmp = q[front];
    q[front] = null;
    front = (++front) % cap;
    count--;
    return tmp;
  }

  @Override
  public String first() {
    if(count == 0) throw new IllegalStateException("Queue is empty");
    return q[front];
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public boolean isEmpty() {
    return count == 0;
  }

  @Override
  public int indexOf(String element) {
    if(element == null) {
      return -1;
    }
    for(int i = 0; i < count; i++) {
      int idx = (front + i) % cap;
      if(element.equals(q[idx])) {
        return i;
      }
    }

    return -1;
  }

  @Override
  public boolean contains(String element) {
    if(element == null) return false;
    for (String t : q) {
      if(element.equals(t)) return true;
    }
    return false;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    for(int i = 0; i < count; i++) {
      int idx = (front + i) % cap;
      sb.append(q[idx]);
      if(i < count -1) {
        sb.append(", ");
      }
    }
    return sb.toString() + "}";
  }

}
