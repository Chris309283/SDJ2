package shared.networking;

import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MsnServer extends Remote
{
  User newUser(String username) throws RemoteException;
  void newMessage(Message message) throws RemoteException;
  List<User> getUsers() throws RemoteException;
  void removeUser(String id) throws RemoteException;
  void registerClient(MsnClient client, User user) throws RemoteException;
}
