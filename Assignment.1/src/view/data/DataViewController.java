package view.data;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

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

    XYChart.Series series = new XYChart.Series();

    if (i==0)
    {
      for (int j = 0; j < dataViewModel.getT0TempList().getSize(); j++)
      {
        series.getData().add(new XYChart.Data(dataViewModel.getT0TempList().get(j).getTime().toString(),dataViewModel.getT0TempList().get(j).getTemp()));
      }
    }
    lineChart.getData().add(series);
  }

  public void backButton(ActionEvent actionEvent)
  {
   vh.openTemperatureView();
  }
}
