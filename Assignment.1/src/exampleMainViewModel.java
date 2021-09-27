/*
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.chart.XYChart;

import java.beans.PropertyChangeEvent;

public class exampleMainViewModel
{

  private StringProperty kurs05 = new SimpleStringProperty();
  private StringProperty kurs10 = new SimpleStringProperty();
  private List<KursContainer> kurser05;
  private List<KursContainer> kurser10;
  private XYChart.Series dataSeries05 = new XYChart.Series();
  private XYChart.Series dataSeries10 = new XYChart.Series();
  private DoubleProperty upperBound = new SimpleDoubleProperty();
  private DoubleProperty lowerBound = new SimpleDoubleProperty();

  public MainViewModel(KursWatcherModel model)
  {
    kurser05 = model.getKurser05();
    kurser10 = model.getKurser10();
    upperBound.set(0);
    lowerBound.set(105);
    model.addListener("NewKurs05", this::onNew05Kurs);
    model.addListener("NewKurs10", this::onNew10Kurs);
    model.addListener("Kurs05Update",
        propertyChangeEvent -> onKursUpdate(propertyChangeEvent, kurs05));
    model.addListener("Kurs10Update",
        propertyChangeEvent -> onKursUpdate(propertyChangeEvent, kurs10));
  }

  private void onKursUpdate(PropertyChangeEvent propertyChangeEvent,
      StringProperty kurs)
  {
    Platform.runLater(() -> {
      KursContainer kursContainer = (KursContainer) propertyChangeEvent.getNewValue();
      kurs.set(kursContainer.kurs);
    });
  }

  private void onNew10Kurs(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(() -> {
      KursContainer s = (KursContainer) propertyChangeEvent.getNewValue();
      dataSeries10.getData().add(new XYChart.Data(s.date,
          Double.parseDouble(s.kurs.replace(',', '.'))));
    });
  }

  private void onNew05Kurs(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(() -> {
      KursContainer s = (KursContainer) propertyChangeEvent.getNewValue();
      dataSeries05.getData().add(new XYChart.Data(s.date,
          Double.parseDouble(s.kurs.replace(',', '.'))));
    });
  }

  public XYChart.Series getKurs05DataSeries()
  {
    return checkKurser(kurser05, dataSeries05, kurs05);
  }

  public XYChart.Series getKurs10DataSeries()
  {
    return checkKurser(kurser10, dataSeries10, kurs10);
  }

  private XYChart.Series checkKurser(List<KursContainer> kurser,
      XYChart.Series dataSeries, StringProperty kurs)
  {
    for (KursContainer s : kurser)
    {
      double d = Double.parseDouble(s.kurs.replace(',', '.'));
      if (d > upperBound.get())
        upperBound.set(d);
      if (d < lowerBound.get())
        lowerBound.set(d);
      dataSeries.getData().add(new XYChart.Data(s.date, d));
    }
    upperBound.set(upperBound.get() + 0.5);
    lowerBound.set(lowerBound.get() - 0.5);
    kurs.set(kurser.get(kurser.size() - 1).kurs);
    return dataSeries;
  }

  public ObservableValue<? extends Number> upperBoundProperty()
  {
    return upperBound;
  }

  public ObservableValue<? extends Number> lowerBoundProperty()
  {
    return lowerBound;
  }

  public StringProperty kurs05Property()
  {
    return kurs05;
  }

  public StringProperty kurs10Property()
  {
    return kurs10;
  }
}


*/
