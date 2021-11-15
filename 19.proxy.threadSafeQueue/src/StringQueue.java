public interface StringQueue
{
  void enqueue(String element);
  String dequeue();
  String first();
  int size();
  int indexOf(String element);
  boolean isEmpty();
  boolean contains(String element);
}
