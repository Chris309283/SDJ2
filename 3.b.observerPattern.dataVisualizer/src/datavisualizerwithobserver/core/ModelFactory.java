package datavisualizerwithobserver.core;

import datavisualizerwithobserver.model.DataModel;
import datavisualizerwithobserver.model.Model;

public class ModelFactory {

    private Model model;

    public Model getModel() {
        if(model == null) model = new DataModel();
        return model;
    }
}
