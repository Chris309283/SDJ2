package datavisualizerwithobserver.view.piechart;

import datavisualizerwithobserver.model.Model;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PieChartViewModel {

    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty z;
    private StringProperty updateTimeStamp;


    public PieChartViewModel(Model model) {
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        z = new SimpleDoubleProperty();
        updateTimeStamp = new SimpleStringProperty("Last update: ");

        model.addListener("Data", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updatePieChart(evt);
            }
        });

        model.addListener("Data", evt -> updatePieChart(evt));
        model.addListener("TimeUpdate", evt -> timeStampUpdated(evt));
    }

    public void updatePieChart(PropertyChangeEvent evt) {

        //Platform.runLater();
        Platform.runLater(() -> {
            double[] vals = (double[]) evt.getNewValue();
            x.setValue(vals[0]);
            y.setValue(vals[1]);
            z.setValue(vals[2]);
        });
    }

    private void timeStampUpdated(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            updateTimeStamp.setValue("Last updated: " + evt.getNewValue());
        });
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public DoubleProperty zProperty() {
        return z;
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }
}
