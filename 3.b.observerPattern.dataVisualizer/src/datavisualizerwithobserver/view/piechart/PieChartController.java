package datavisualizerwithobserver.view.piechart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class PieChartController {

    @FXML
    Label eventLabel;

    @FXML
    PieChart pieChart;

    private PieChart.Data yellow = new PieChart.Data("X", 0);
    private PieChart.Data green = new PieChart.Data("Y", 0);
    private PieChart.Data red = new PieChart.Data("Z", 0);


    public void init(PieChartViewModel pieChartViewModel) {

        PieChartViewModel viewModel = pieChartViewModel;

        yellow.pieValueProperty().bind(viewModel.xProperty());
        green.pieValueProperty().bind(viewModel.yProperty());
        red.pieValueProperty().bind(viewModel.zProperty());

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        ObservableList<PieChart.Data> datas = FXCollections.observableArrayList(yellow, green, red);
        pieChart.setData(datas);

    }

}
