package view.data;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import mediator.TemperatureHubModel;
import model.temperature.Temperature;
import model.temperature.TemperatureList;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class DataViewModel
{
  private TemperatureHubModel model;
 private ObservableList<XYChart.Data<String,Double>>list;
 private XYChart.Series tempSeries = new XYChart.Series();

 private TemperatureList t0TempList;


  public DataViewModel(TemperatureHubModel model)
  {
    t0TempList = model.getTempList0();

    this.model = model;


      model.addPropertyChangeListener(this::updateTempLists);
  }

  public void updateTempLists(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("t0Temp"))
      {
        tempSeries.getData().removeAll();
        for (int i = 0; i < t0TempList.getSize(); i++)
        {
          tempSeries.getData().add(new XYChart.Data<>(t0TempList.get(i).getTime().toString(),t0TempList.get(i).getTemp()));
        }
      }
    });
  }

  public TemperatureList getT0TempList()
  {
    return t0TempList;
  }

  public XYChart.Series getTempSeries()
  {
    return tempSeries;
  }
}
