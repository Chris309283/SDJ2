import core.ViewHandler;
import javafx.stage.Stage;

public class UppercaseApp extends javafx.application.Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ViewHandler vh = new ViewHandler();
    vh.start();
  }
}
