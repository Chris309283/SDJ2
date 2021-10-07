package Login.client.model;

import Login.client.mediator.UserClient;

import java.io.IOException;

public class ModelManager implements Model
{
  public ModelManager()
  {
  }

  @Override public void login(String userName, String password)
      throws IllegalStateException, IllegalArgumentException
  {
    try
    {
      UserClient userClient = new UserClient("localhost",2910);
      userClient.login(userName,password);
    }
      catch (IOException e)
      {
        e.printStackTrace();
      }
  }
}
