package view.data;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import mediator.TemperatureHubModel;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeEvent;

public class DataViewModel
{
  private TemperatureHubModel model;
  private XYChart.Series t0TempSeries = new XYChart.Series();
  private XYChart.Series t1TempSeries = new XYChart.Series();
  private XYChart.Series t2TempSeries = new XYChart.Series();

  private TemperatureList t0TempList, t1TempList, t2TempList;

  public DataViewModel(TemperatureHubModel model)
  {
    t0TempList = model.getTempList0();
    t1TempList = model.getTempList1();
    t2TempList = model.getTempList2();

    this.model = model;
    model.addPropertyChangeListener(this::updateTempLists);
  }

  public void updateTempLists(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("t0Temp"))
      {
        t0TempSeries.getData().clear();
        for (int i = 0; i < t0TempList.getSize(); i++)
        {
          t0TempSeries.getData().add(
              new XYChart.Data<>(t0TempList.get(i).getTime().toString(),
                  t0TempList.get(i).getTemp()));
        }
      }
      if (evt.getPropertyName().equals("t1Temp"))
      {
        t1TempSeries.getData().clear();
        for (int i = 0; i < t1TempList.getSize(); i++)
        {
          t1TempSeries.getData().add(
              new XYChart.Data<>(t1TempList.get(i).getTime().toString(),
                  t1TempList.get(i).getTemp()));
        }
      }
      if (evt.getPropertyName().equals("t2Temp"))
      {
        t2TempSeries.getData().clear();
        for (int i = 0; i < t2TempList.getSize(); i++)
        {
          t2TempSeries.getData().add(
              new XYChart.Data<>(t2TempList.get(i).getTime().toString(),
                  t2TempList.get(i).getTemp()));
        }
      }
    });
  }

  public XYChart.Series getT0TempSeries()
  {
    return t0TempSeries;
  }

  public XYChart.Series getT1TempSeries()
  {
    return t1TempSeries;
  }

  public XYChart.Series getT2TempSeries()
  {
    return t2TempSeries;
  }
}
