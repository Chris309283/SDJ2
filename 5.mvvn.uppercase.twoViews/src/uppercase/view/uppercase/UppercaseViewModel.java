package uppercase.view.uppercase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import uppercase.model.TextConverter;

public class UppercaseViewModel
{
  private TextConverter textConverter;
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;

  public UppercaseViewModel(TextConverter textConverter)
  {
    this.textConverter = textConverter;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert()
  {
  String input = request.get();
  if (input != null && !"".equals(input))
  {
    error.set("");
    String result = textConverter.toUppercase(input);
    reply.set(result);
    textConverter.addLog("Converted: "+input);
  }
  else
  {
    reply.set("");
    error.set("Source Text is Empty");
  }
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
}
