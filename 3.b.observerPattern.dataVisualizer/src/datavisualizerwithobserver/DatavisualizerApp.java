package datavisualizerwithobserver;

import datavisualizerwithobserver.core.ModelFactory;
import datavisualizerwithobserver.model.DataModel;
import datavisualizerwithobserver.model.Model;
import datavisualizerwithobserver.core.ViewHandler;
import datavisualizerwithobserver.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;

public class DatavisualizerApp extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler mv = new ViewHandler(vmf);
        mv.start();

        runAutoUpdate((DataModel) mf.getModel());
    }

    private void runAutoUpdate(DataModel m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(10000) + 5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }

    @Override
    public void stop() throws Exception {

    }
}
