package uppercase;

import javafx.stage.Stage;
import uppercase.core.ModelFactory;
import uppercase.core.ViewHandler;
import uppercase.core.ViewModelFactory;

public class UppercaseApp extends javafx.application.Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
        vh.start();
  }
}
