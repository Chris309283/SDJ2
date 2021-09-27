package view.data;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import mediator.TemperatureHubModel;
import model.temperature.Temperature;
import model.temperature.TemperatureList;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class DataViewModel
{
  private TemperatureHubModel model;
 private List<Temperature> list;
 private XYChart.Series tempSeries = new XYChart.Series();

 private TemperatureList t0TempList;


  public DataViewModel(TemperatureHubModel model)
  {
    t0TempList = model.getTempList0();

    this.model = model;
    list = model.getTempList0().getList();


  }

  public void updateTempLists(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("t0Temp"))
      {

      }
    });
  }

  public TemperatureList getT0TempList()
  {
    return t0TempList;
  }
}
