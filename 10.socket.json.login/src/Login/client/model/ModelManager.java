package Login.client.model;

import Login.client.mediator.UserClient;

import java.io.IOException;

public class ModelManager implements Model
{

  private final UserClient userClient;

  public ModelManager() throws IOException
  {
    this.userClient = new UserClient();
  }

  @Override public void login(String userName, String password)
      throws IllegalStateException, IllegalArgumentException
  {
    userClient.login(userName,password);
  }
}
