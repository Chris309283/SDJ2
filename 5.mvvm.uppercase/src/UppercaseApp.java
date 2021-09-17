import core.ViewHandler;
import core.ViewModelFactory;
import javafx.stage.Stage;

public class UppercaseApp extends javafx.application.Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ViewModelFactory vmf = new ViewModelFactory();
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
