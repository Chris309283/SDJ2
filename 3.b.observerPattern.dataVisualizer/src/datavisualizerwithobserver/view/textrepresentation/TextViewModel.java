package datavisualizerwithobserver.view.textrepresentation;

import datavisualizerwithobserver.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class TextViewModel {

    private StringProperty x;
    private StringProperty y;
    private StringProperty z;
    private StringProperty updateTimeStamp;

    private Model model;

    public TextViewModel(Model model) {
        this.model = model;
        x = new SimpleStringProperty();
        y = new SimpleStringProperty();
        z = new SimpleStringProperty();
        updateTimeStamp = new SimpleStringProperty();

        model.addListener("Data", evt -> updateTextFields(evt));
        model.addListener("TimeUpdate", evt -> timeStampUpdated(evt));

    }

    private void updateTextFields(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            double[] vals = (double[]) evt.getNewValue();
            x.setValue("" + vals[0]);
            y.setValue("" + vals[1]);
            z.setValue("" + vals[2]);
        });
    }

    private void timeStampUpdated(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            updateTimeStamp.setValue("Last updated: " + evt.getNewValue());
        });
    }

    public StringProperty xStringProperty() {
        return x;
    }

    public StringProperty yStringProperty() {
        return y;
    }

    public StringProperty zStringProperty() {
        return z;
    }

    public StringProperty labelStringProperty() {
        return updateTimeStamp;
    }

    public void saveChanges() {
        double xDouble = Double.parseDouble(x.getValue());
        double v1 = Double.parseDouble(y.getValue());
        double v2 = Double.parseDouble(z.getValue());
        double[] data = {
                xDouble,
                v1,
                v2
        };
        model.saveData(data);
    }
}
