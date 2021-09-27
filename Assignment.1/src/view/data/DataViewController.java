package view.data;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import view.ViewController;
import core.ViewHandler;
import core.ViewModelFactory;

public class DataViewController implements ViewController
{
  private ViewHandler vh;
  private DataViewModel dataViewModel;

  @FXML private LineChart<?, ?> lineChart;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, int i)
  {
    this.vh = vh;
    this.dataViewModel = vmf.getDataViewModel();

    if (i == 0)
    {
      lineChart.getData().setAll(dataViewModel.getT0TempSeries());
    }
    if (i == 1)
    {
      lineChart.getData().setAll(dataViewModel.getT1TempSeries());
    }
    if (i == 2)
    {
      lineChart.getData().setAll(dataViewModel.getT2TempSeries());
    }
  }

  public void backButton(ActionEvent actionEvent)
  {
    vh.openTemperatureView();
  }
}
