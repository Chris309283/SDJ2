package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory viewModelFactory;
  private Stage stage;
  private Parent root;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    this.stage = new Stage();
  }

  public void openMainView()
  {
    Scene scene = new Scene(getRoot("../views/main/mainview.fxml", null));
    stage.setScene(scene);
    stage.show();
  }

  public void openLoginView()
  {
    stage.setTitle("MSN");
    Scene scene = new Scene(getRoot("../views/login/LoginView.fxml", null));
    stage.setScene(scene);
    stage.show();
  }

  public void openChatTab(Tab allTab, User receiver, Message message)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("../views/chat/chatTab.fxml"));
      allTab.setContent(loader.load());
      ViewController viewController = loader.getController();
      viewController.init(this, viewModelFactory, stage, receiver, message);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private Parent getRoot(String path, User user)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(path));
      root = loader.load();
      ViewController viewController = loader.getController();
      viewController.init(this, viewModelFactory, stage, user, null);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

}
