package test;

public interface ReadWrite
{
  void acquireRead();
  void releaseRead();
  void acquireWrite();
  void releaseWrite();
}
