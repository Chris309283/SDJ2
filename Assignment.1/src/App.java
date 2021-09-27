import external.ExternalTemperature;
import external.Thermometer;
import javafx.stage.Stage;

import core.*;

public class App extends javafx.application.Application
{
  @Override public void start(Stage stage) throws Exception
  {
    //Initializing core///
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf, stage);

    // Running Handler///
    vh.start();

    //Outside Temperature Thread///
    Runnable externalTemp = new ExternalTemperature(mf.getTemperatureHubModel(),
        10, -10, 28);
    Thread externalThread = new Thread(externalTemp);
    externalThread.setDaemon(true);
    externalThread.start();

    //Thermometers Temperature Thread///
    Runnable thermometer1 = new Thermometer(mf.getTemperatureHubModel(),
        "t1Temp", mf.getTemperatureHubModel().getOutsideTemp(), 1);
    Runnable thermometer2 = new Thermometer(mf.getTemperatureHubModel(),
        "t2Temp", mf.getTemperatureHubModel().getOutsideTemp(), 7);

    Thread t1 = new Thread(thermometer1);
    Thread t2 = new Thread(thermometer2);

    t1.setDaemon(true);
    t2.setDaemon(true);

    t1.start();
    t2.start();
  }
}
