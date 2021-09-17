package foxanimation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    public void start() {
        openGameView();
    }

    private void openGameView() {
        try {
            Scene loginScene = getScene("FoxView.fxml");
            Stage mainStage = new Stage();
            mainStage.setTitle("Foxing");

            mainStage.setScene(loginScene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Scene getScene(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        FoxViewController view = loader.getController();
        view.init();
        return new Scene(root);
    }
}
