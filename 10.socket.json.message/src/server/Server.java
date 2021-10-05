package server;

import java.io.IOException;

public class Server
{
  public static void main(String[] args) throws IOException
  {
    ChatServer chatServer = new ChatServer(6798);
    chatServer.execute();
  }
}
