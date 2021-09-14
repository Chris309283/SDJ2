import javafx.application.Application;
import javafx.stage.Stage;
import temperature.external.Thermometer;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    Thermometer tm1 = new Thermometer(model,"tm1",15,1);
    Thermometer tm2 = new Thermometer(model,"tm2",15,7);

    Thread t1 = new Thread(tm1);
    Thread t2 = new Thread(tm2);

    t1.start();
    t2.start();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
