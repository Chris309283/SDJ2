package client.core;

import client.networking.SocketClient;

public class ClientFactory
{
  private SocketClient client;

  public SocketClient getClient() {
    if(client == null) {
      client = new SocketClient();
    }
    return client;
  }
}
