package view.data;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import mediator.TemperatureHubModel;
import model.temperature.Temperature;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeEvent;

public class DataViewModel
{
  private ObservableList<XYChart.Data<String, Number>> list0, list1, list2;

  private TemperatureHubModel model;

  private TemperatureList t0TempList, t1TempList, t2TempList;

  public DataViewModel(TemperatureHubModel model)
  {

    this.list0 = FXCollections.observableArrayList();
    this.list1 = FXCollections.observableArrayList();
    this.list2 = FXCollections.observableArrayList();

    this.t0TempList = model.getTempList0();
    this.t1TempList = model.getTempList1();
    this.t2TempList = model.getTempList2();

    this.model = model;
    model.addPropertyChangeListener(this::updateTempLists);
  }

  public void StartTempLists()
  {
    for (int i = 0; i < t0TempList.getSize(); i++)
    {
      list0.add(new XYChart.Data<>(t0TempList.get(i).getTime(),
          t0TempList.get(i).getTemp()));
    }

    for (int i = 0; i < t1TempList.getSize(); i++)
    {
      list1.add(new XYChart.Data<>(t1TempList.get(i).getTime(),
          t1TempList.get(i).getTemp()));
    }

    for (int i = 0; i < t2TempList.getSize(); i++)
    {
      list2.add(new XYChart.Data<>(t2TempList.get(i).getTime(),
          t2TempList.get(i).getTemp()));
    }
  }

  public void updateTempLists(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("t0Temp"))
      {
        list0.clear();
        for (int i = 0; i < t0TempList.getSize(); i++)
        {
          list0.add(new XYChart.Data<>(t0TempList.get(i).getTime(),
              t0TempList.get(i).getTemp()));
        }
      }
      if (evt.getPropertyName().equals("t1Temp"))
      {
        Temperature t = (Temperature)evt.getNewValue();
        XYChart.Data<String, Number> data = new XYChart.Data<>(
            t.getTime(), t.getTemp());
        list1.add(data);
        System.out.println(t);
//        list1.clear();
//        for (int i = 0; i < t1TempList.getSize(); i++)
//        {
//          list1.add(new XYChart.Data<>(t1TempList.get(i).getTime(),
//              t1TempList.get(i).getTemp()));
//        }
      }
      if (evt.getPropertyName().equals("t2Temp"))
      {
        list2.clear();
        for (int i = 0; i < t2TempList.getSize(); i++)
        {
          list2.add(new XYChart.Data<>(t2TempList.get(i).getTime(),
              t2TempList.get(i).getTemp()));
        }
      }
    });
  }

  public ObservableList<XYChart.Data<String, Number>> getList1()
  {
    return list1;
  }

  public ObservableList<XYChart.Data<String, Number>> getList0()
  {
    return list0;
  }

  public ObservableList<XYChart.Data<String, Number>> getList2()
  {
    return list2;
  }
}
