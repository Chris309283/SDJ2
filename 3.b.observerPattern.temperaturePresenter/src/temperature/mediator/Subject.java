package temperature.mediator;

public interface Subject
{
  public void addListener(Listener Istnr);
  public void removeListener(Listener Istnr);
}
