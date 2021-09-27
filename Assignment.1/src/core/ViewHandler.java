package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewController;
import model.temperature.TemperatureList;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf, Stage stage)
  {
    this.vmf = vmf;
    this.mainStage = stage;
  }

  public void start()
  {
    openTemperatureView();
  }

  private Scene tempScene;
  private Scene dataScene;

  public void openTemperatureView()
  {
    try
    {
      if (tempScene == null)
      {
        tempScene = getScene("../view/temperature/TemperatureView.fxml", -1);
      }
        changeScene("Temperatures", tempScene);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void openDataView(int i)
  {

    try
    {
      //if (dataScene == null)
      {
        dataScene = getScene("../view/data/DataView.fxml", i);
      }
        changeScene("Data view", dataScene);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void changeScene(String s, Scene scene)
  {
    mainStage.setTitle(s);
    mainStage.setScene(scene);
    mainStage.show();
  }

  private Scene getScene(String path, int i)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();

      loader.setLocation(getClass().getResource(path));
      Parent root = loader.load();

      ViewController view = loader.getController();
      view.init(this,vmf, i);

      return new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    throw new RuntimeException("Failed to create scene");
  }
}
