package client.views.login;

import client.model.ChatAppModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private ChatAppModel chatAppModel;
  private StringProperty username;

  public LoginViewModel(ChatAppModel chatAppModel)
  {
    this.chatAppModel=chatAppModel;
    this.username = new SimpleStringProperty();
  }

  public void newUser()
  {
    chatAppModel.newUser(username.getValue());
  }

  public StringProperty getUsername()
  {
    return username;
  }
}
