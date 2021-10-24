package client.core;

import client.model.ChatAppModel;
import client.model.ChatAppModelManager;

public class ModelFactory
{
  private ChatAppModel chatAppModel;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory=clientFactory;
  }

  public ChatAppModel getChatAppModel()
  {
    if (chatAppModel == null)
    {
      this.chatAppModel= new ChatAppModelManager(clientFactory.getClient());
    }
    return chatAppModel;
  }
}
