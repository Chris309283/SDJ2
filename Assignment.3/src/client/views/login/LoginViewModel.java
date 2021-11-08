package client.views.login;

import client.model.MsnModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private MsnModel msnModel;
  private StringProperty username;

  public LoginViewModel(MsnModel msnModel)
  {
    this.msnModel = msnModel;
    this.username = new SimpleStringProperty();
  }

  public void newUser()
  {
    msnModel.newUser(username.getValue());
  }

  public String getUsername()
  {
    return username.get();
  }

  public StringProperty usernameProperty()
  {
    return username;
  }
}
