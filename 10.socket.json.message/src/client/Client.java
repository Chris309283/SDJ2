package client;

import java.io.IOException;

public class Client
{
  public static void main(String[] args) throws IOException
  {
    ChatClient chatClient = new ChatClient("localhost",6798);
    chatClient.execute();
  }
}
