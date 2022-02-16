import Mine.Valuable;

import java.util.ArrayList;

public interface TreasureRoomDoor
{
  void acquiredRead();
  void releaseRead();
  void acquireWrite();
  void releaseWrite();
  void add(Runnable character, ArrayList<Valuable> valuableTransportBag);
  Valuable retrieve(Runnable character);
  int look(Runnable character);
}
