package client.views.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import shared.transferobjects.Message;
import shared.transferobjects.User;

public class LoginViewController implements ViewController
{
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;

  @FXML private TextField userNameField;
  @FXML private Button startButton;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory, Stage stage, User receiver,
      Message initMessage)
  {
    this.loginViewModel=viewModelFactory.getLoginViewModel();
    this.viewHandler=viewHandler;
    userNameField.textProperty().bindBidirectional(loginViewModel.usernameProperty());

    startButton.disableProperty().bind(Bindings.isEmpty(userNameField.textProperty()));

    userNameField.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER)
      {
        startButton(null);
      }
    });
  }

  public void startButton(ActionEvent actionEvent)
  {
    if(userNameField.textProperty().getValue()!=null && !(userNameField.textProperty().getValue().equals("")))
    {
      loginViewModel.newUser();
      viewHandler.openMainView();
    }
  }
}
