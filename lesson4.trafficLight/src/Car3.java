import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car3
{
  public Car3(PropertyChangeSubject subject)
  {
    PropertyChangeListener listener ;

    subject.addPropertyChangeListener("LightChanged",this::reactToChange);
  }

  public void reactToChange(PropertyChangeEvent evt)
  {
    String oldValue = (String) evt.getOldValue();
    String newValue = (String) evt.getNewValue();

    if (newValue.equals("GREEN"))
    {
      System.out.println("Car 3 drives");
    }
    else if (newValue.equals("YELLOW"))
    {
      if ("RED".equals(oldValue))
      {
        System.out.println("Car 3 turns engine on");
      }
      else
      {
        System.out.println("Car 3 slows down");
      }
    }
    else if ("RED".equals(newValue))
    {
      System.out.println("Car 3 stops");
    }

  }
}
