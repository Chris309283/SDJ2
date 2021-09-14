import java.beans.PropertyChangeEvent;

public class Car4
{
  public Car4(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener("GREEN",this::reactToGreen);
    subject.addPropertyChangeListener("YELLOW",this::reactToYellow);
    subject.addPropertyChangeListener("RED",this::reactToRed);
  }

  public void reactToRed(PropertyChangeEvent evt){
    System.out.println("Car 4 stops");
  }

  public void reactToYellow(PropertyChangeEvent evt){
    if ("RED".equals(evt.getOldValue()))
    {
      System.out.println("Car 4 turns engine on");
    }
    else
    {
      System.out.println("Car 4 slows down");
    }
  }

  public void  reactToGreen(PropertyChangeEvent evt){
    System.out.println("Car 4 drives");
  }
}
