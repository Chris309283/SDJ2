package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory vmf;

  private ViewController currentlyActive;

  public ViewHandler(ViewModelFactory vmf, Stage stage)
  {
    this.vmf = vmf;
    this.stage = stage;
  }

  public void start() throws IOException
  {
    Scene scene;
    Parent root;

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/temperature/TemperatureView.fxml"));
    root = loader.load();

    ViewController ctrl = loader.getController();
    currentlyActive = ctrl;
    ctrl.init(this,vmf);

    stage.setTitle("Temperature Controller");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public Parent openTemperatureView()
  {
    currentlyActive.reset();
    return getRoot("../view/temperature/TemperatureView.fxml");
  }

  public Parent openDataView()
  {
    currentlyActive.reset();
    return getRoot("../view/data/DataView.fxml");
  }

  private Parent getRoot(String path)
  {
    Parent root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(path));
      root = loader.load();
      ViewController ctrl = loader.getController();
      currentlyActive = ctrl;
      ctrl.init(this,vmf);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  public void openData(int i) {

  }
}
