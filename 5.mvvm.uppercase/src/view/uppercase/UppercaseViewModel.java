package view.uppercase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UppercaseViewModel
{
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;
  private UppercaseViewModel viewModel;

  public UppercaseViewModel()
  {
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert()
  {
    System.out.println("Hello from VM");
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public StringProperty requestProperty()
  {
    return request;
  }

  public StringProperty replyProperty()
  {
    return reply;
  }

  public void init(UppercaseViewModel uppercaseVM)
  {
    this.viewModel = uppercaseVM;
  }
}
