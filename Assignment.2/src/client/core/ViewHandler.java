package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private ViewModelFactory vmf;
  private Scene chatScene;
  private Scene loginScene;
  private Scene userListScene;

  public ViewHandler(Stage mainStage, ViewModelFactory vmf)
  {
    this.mainStage = mainStage;
    this.vmf = vmf;
  }

  public void start()
  {
    openLoginView();
  }

  public void openLoginView()
  {
    try
    {
      if (loginScene == null)
      {
        loginScene = getScene("../views/login/LoginView.fxml");
      }
      changeScene("Login", loginScene);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    throw new RuntimeException("Failed to load login scene");
  }

  public void openChatView()
  {
    try
    {
      if (chatScene == null)
      {
        chatScene = getScene("../views/login/ChatView.fxml");
      }
      changeScene("Chat", chatScene);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    throw new RuntimeException("Failed to load chat scene");
  }

  public void openUserListView()
  {
    try
    {
      if (userListScene == null)
      {
        userListScene = getScene("../views/login/UserListView.fxml");
      }
      changeScene("server.model.login.User List", userListScene);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    throw new RuntimeException("Failed to load user list scene");
  }

  private void changeScene(String s, Scene scene)
  {
    mainStage.setTitle(s);
    mainStage.setScene(scene);
    mainStage.show();
  }

  private Scene getScene(String path)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();

      loader.setLocation(getClass().getResource(path));
      Parent root = loader.load();

      ViewController view = loader.getController();
      view.init(this, vmf);

      return new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    throw new RuntimeException("Failed to create scene");
  }

}
