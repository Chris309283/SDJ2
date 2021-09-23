import external.ExternalTemperature;
import external.Thermometer;
import javafx.stage.Stage;

import viewmodel.*;

public class App extends javafx.application.Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh= new ViewHandler(vmf,stage);

    //Creating Threads///
    Runnable externalTemp = new ExternalTemperature(mf.getTemperatureHubModel(), 0, -10, 28);

    Runnable thermometer1 = new Thermometer(mf.getTemperatureHubModel(),"t1Temp", 15,1);
    Runnable thermometer2 = new Thermometer(mf.getTemperatureHubModel(),"t2Temp", 15,7);

    Thread externalThread = new Thread(externalTemp);

    Thread t1 = new Thread(thermometer1);
    Thread t2 = new Thread(thermometer2);

    // Running Handler///
    vh.start();

    //Running Threads//
    externalThread.setDaemon(true);
    t1.setDaemon(true);
    t2.setDaemon(true);

    externalThread.start();
    t1.start();
    t2.start();
  }
}
