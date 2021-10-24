package datavisualizerwithobserver.core;

import datavisualizerwithobserver.view.barchart.BarChartController;
import datavisualizerwithobserver.view.piechart.PieChartController;
import datavisualizerwithobserver.view.textrepresentation.TextController;
import datavisualizerwithobserver.core.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory mvViewModel;

    public ViewHandler(ViewModelFactory mvViewModel) {
        this.mvViewModel = mvViewModel;
    }

    public void start() throws Exception{
        openView("BarChart");
        openView("PieChart");
        openView("Text");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        Stage tmpStage = new Stage();
        if("PieChart".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("../view/piechart/PieChart.fxml"));
            root = loader.load();
            PieChartController view = loader.getController();
            view.init(mvViewModel.getPieChartViewModel());
            tmpStage.setTitle("Pie Chart");
        } else if("BarChart".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("../view/barchart/BarChart.fxml"));
            root = loader.load();
            BarChartController view = loader.getController();
            view.init(mvViewModel.getBarChartViewModel());
            tmpStage.setTitle("Bar Chart");
        } else if ("Text".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("../view/textrepresentation/Text.fxml"));
            root = loader.load();
            TextController view = loader.getController();
            view.init(mvViewModel.getTextViewModel());
            tmpStage.setTitle("Pie Chart");
        }

        scene = new Scene(root);
        tmpStage.setScene(scene);
        tmpStage.show();
    }
}
