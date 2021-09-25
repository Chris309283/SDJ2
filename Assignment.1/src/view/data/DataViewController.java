package view.data;

import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import view.ViewController;
import core.ViewHandler;
import core.ViewModelFactory;

public class DataViewController implements ViewController
{
  private ViewHandler vh;
  private DataViewModel dataViewModel;

  public LineChart lineChart;

  public void backButton(ActionEvent actionEvent)
  {

  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.dataViewModel = vmf.getDataViewModel();


  }

  @Override public void reset()
  {

  }
}
