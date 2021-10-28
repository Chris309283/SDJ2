package client;

import server.TextConverter;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiCaseClient
{
  private TextConverter serverStub;

  public RmiCaseClient()
  {
    try
    {
      serverStub = (TextConverter) Naming.lookup("rmi://localhost:1099/Case");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public String convert(String text, Boolean upper) throws RemoteException
  {
    if (upper)
    {
      return serverStub.toUpperCase(text);
    }
    else
      return serverStub.capitalizeFirstCharacter(text);
  }
}
