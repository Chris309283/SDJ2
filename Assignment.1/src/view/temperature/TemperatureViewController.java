package view.temperature;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.ViewController;
import core.ViewHandler;
import core.ViewModelFactory;

public class TemperatureViewController implements ViewController
{
  private ViewHandler vh;
  private TemperatureViewModel temperatureViewModel;

  @FXML private TextField t0Temp;
  @FXML private TextField t1Temp;
  @FXML private TextField t2Temp;
  @FXML private TextField radiatorField;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, int i)
  {
    this.vh=vh;
    this.temperatureViewModel = vmf.getTemperatureViewModel();

    radiatorField.textProperty().bind(temperatureViewModel.radiatorProperty().asString());
    t0Temp.textProperty().bind(temperatureViewModel.t0TempProperty().asString());
    t1Temp.textProperty().bind(temperatureViewModel.t1TempProperty().asString());
    t2Temp.textProperty().bind(temperatureViewModel.t2TempProperty().asString());
  }

  public void radButtonUp(ActionEvent actionEvent)
  {
    temperatureViewModel.radiatorUp();
  }

  public void radButtonDown(ActionEvent actionEvent)
  {
    temperatureViewModel.radiatorDown();
  }

  public void t0DataButton(ActionEvent actionEvent)
  {
    vh.openDataView(0);
  }

  public void t1DataButton(ActionEvent actionEvent)
  {
    vh.openDataView(1);
  }

  public void t2DataButton(ActionEvent actionEvent)
  {
    vh.openDataView(2);
  }
}
