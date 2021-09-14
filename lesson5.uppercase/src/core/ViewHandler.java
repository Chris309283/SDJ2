package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene uppercaseScene;
  private Stage stage;

  public ViewHandler()
  {
  }

  public void start()
  {
    stage = new Stage();
    openToUppercase();
  }

  public void openToUppercase()
  {
    if (uppercaseScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/uppercase/UppercaseView.fxml"));
        Parent root = null;
        root = loader.load();
        stage.setTitle("Upper Case");
        uppercaseScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(uppercaseScene);
      stage.show();
    }
  }

  }
