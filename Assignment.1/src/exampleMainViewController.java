/*
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;

public class exampleMainViewController
{
  @FXML Label kurs10Label;
  @FXML
  Label kurs05Label;
  @FXML LineChart chart;

  @FXML NumberAxis yAxis;

  private MainViewModel vm;

  public void init(MainViewModel viewModel) {
    vm = viewModel;

    kurs05Label.textProperty().bind(vm.kurs05Property());
    kurs10Label.textProperty().bind(vm.kurs10Property());

    yAxis.setAutoRanging(false);
    yAxis.upperBoundProperty().bind(vm.upperBoundProperty());
    yAxis.lowerBoundProperty().bind(vm.lowerBoundProperty());
    yAxis.setTickUnit(0.1);


    chart.getData().add(vm.getKurs05DataSeries());
    chart.getData().add(vm.getKurs10DataSeries());
  }

}
*/
