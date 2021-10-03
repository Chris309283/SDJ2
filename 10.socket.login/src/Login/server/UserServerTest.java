package Login.server;

import Login.server.mediator.UserServer;
import Login.server.model.Model;
import Login.server.model.ModelManager;

import java.io.IOException;

public class UserServerTest
{
  public static void main(String[] args) throws IOException
  {
    Model model = new ModelManager();
    Thread t = new Thread(new UserServer(model));
    t.start();
  }
}
