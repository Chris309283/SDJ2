package server;

import server.model.chat.ChatModelManager;
import server.model.login.LoginModelManager;
import server.networking.SocketServer;

public class RunServer
{


  public static void main(String[] args)
  {
    ChatModelManager chatModelManager = new ChatModelManager();
    LoginModelManager loginModelManager = new LoginModelManager();
    SocketServer socketServer = new SocketServer(chatModelManager,loginModelManager);
    socketServer.startServer();
  }
}
