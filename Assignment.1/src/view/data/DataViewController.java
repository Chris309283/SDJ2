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
  private XYChart.Series<String, Number> series0, series1, series2;

  @FXML private LineChart<String, Number> lineChart;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, int i)
  {
    this.vh = vh;
    this.dataViewModel = vmf.getDataViewModel();
    dataViewModel.StartTempLists();

    if (i == 0)
    {
      series0 = new XYChart.Series<>();
      series0.setName("T0");
      series0.setData(dataViewModel.getList0());
      lineChart.getData().add(series0);
    }
    if (i == 1)
    {
      series1 = new XYChart.Series<>();
      series1.setName("T1");
      series1.setData(dataViewModel.getList1());
      lineChart.getData().add(series1);
    }
    if (i == 2)
    {
      series2 = new XYChart.Series<>();
      series2.setName("T2");
      series2.setData(dataViewModel.getList2());
      lineChart.getData().add(series2);
    }
  }

  public void backButton(ActionEvent actionEvent)
  {
    vh.openTemperatureView();
  }
}
