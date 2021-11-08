package shared.networking;

import shared.transferobjects.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MsnClient extends Remote
{
  void update(Request request) throws RemoteException;
}
