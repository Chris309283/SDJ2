package uppercase.view.log;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uppercase.model.TextConverter;

public class LogViewModel
{
  private TextConverter textConverter;
  private ObservableList<String> logs;

  public LogViewModel(TextConverter textConverter)
  {
    this.textConverter = textConverter;
    logs = FXCollections.observableArrayList();
  }

  public ObservableList<String> getLogs()
  {
    return logs;
  }
}
