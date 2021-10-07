package Login.server.mediator;

import Login.server.model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable
{
  private final int PORT = 2910;
  private boolean running;
  private ServerSocket welcomeSocket;
  private Model model;

  public UserServer(Model model) throws IOException
  {
   this.model=model;
   this.welcomeSocket = new ServerSocket(PORT);
   this.running = true;
  }

  public void close()
  {
   running=false;
  }

  @Override public void run()
  {
    System.out.println("Starting server...");

      try
      {
        while (running)
        {
        System.out.println("Waiting for clients...");
        Socket socket = welcomeSocket.accept();
        UserClientHandler userClientHandler = new UserClientHandler(socket,model);
        Thread t = new Thread(userClientHandler);
        t.start();
        System.out.println("A Client has been connected");
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
  }
}
