package socketsuppercase.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import socketsuppercase.client.views.ViewController;

import java.io.IOException;

public class ViewHandler {

    private Scene uppercaseScene;
    private Stage stage;
    private ViewModelFactory vmf;
    private Scene logScene;

    private ViewController currentlyActive;

    public ViewHandler(ViewModelFactory vmf, Stage stage) {
        this.stage = stage;
        this.vmf = vmf;
    }

//    public void start() {
//        stage = new Stage();
//        openToUppercase();
//    }

    public void start() throws IOException
    {
        Scene scene;
        Parent root;

        scene = getMasterView();
        stage.setScene(scene);
        stage.show();
    }

    public Scene getMasterView() throws IOException
    {
        Parent root;
        Scene scene;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/master/MasterView.fxml"));
        root = loader.load();

        ViewController ctrl = loader.getController();
        currentlyActive = ctrl;
        ctrl.init(this, vmf);

        stage.setTitle("Converter");
        scene = new Scene(root);
        return scene;
    }

    //    public void openToUppercase() {
//        if (uppercaseScene == null) {
//            try {
//                Parent root = loadFXML("../views/uppercase/UppercaseView.fxml");
//
//                stage.setTitle("Upper case");
//                uppercaseScene = new Scene(root);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        stage.setScene(uppercaseScene);
//        stage.show();
//    }

    public Parent getUpperCaseView() {
        currentlyActive.reset();
        return getRoot("../views/uppercase/UppercaseView.fxml");
    }

    public Parent getLowerCaseView() {
        currentlyActive.reset();
        return getRoot("../views/lowercase/LowercaseView.fxml");
    }

    public Parent getCamelCaseView() {
        currentlyActive.reset();
        return getRoot("../views/camelcase/CamelcaseView.fxml");
    }

    private Parent getRoot(String s) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(s));
            root = loader.load();
            ViewController ctrl = loader.getController();
            currentlyActive = ctrl;
            ctrl.init(this, vmf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public void openLog() {
        // no reusing a logScene, because I want the log to reload the latest every time.
        if (logScene == null) {
            try {
                Parent root = loadFXML("../views/log/Log.fxml");

                logScene = new Scene(root);
                stage.setTitle("Log");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(logScene);
        stage.show();
    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }
}
