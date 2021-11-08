package client.core;

import client.model.MsnModel;
import client.model.MsnModelManager;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private MsnModel msnModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
    this.msnModel = new MsnModelManager(clientFactory.getClient());
  }

  public MsnModel getMsnModel()
  {
    return msnModel;
  }
}
