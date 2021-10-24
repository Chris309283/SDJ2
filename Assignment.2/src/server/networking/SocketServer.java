package server.networking;

import server.model.chat.ChatModelManager;
import server.model.login.LoginModelManager;
import shared.util.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private ChatModelManager chatModelManager;
  private LoginModelManager loginModelManager;

  public SocketServer(ChatModelManager chatModelManager,
      LoginModelManager loginModelManager)
  {
    this.chatModelManager = chatModelManager;
    this.loginModelManager = loginModelManager;
  }

  public void startServer()
  {

    try
    {
      System.out.println("Starting Server...");
      ServerSocket listenSocket = new ServerSocket(Connection.PORT);
      while (true)
      {
        System.out.println("Waiting for clients...");
        Socket socket = listenSocket.accept();
        new Thread(new SocketHandler(socket, chatModelManager,
            loginModelManager)).start();
        System.out.println("A client has connected " + socket.getInetAddress()
            .getHostAddress());
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
