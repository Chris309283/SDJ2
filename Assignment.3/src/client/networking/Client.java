package client.networking;

import shared.transferobjects.Message;
import shared.transferobjects.User;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{
  void newUser(String UserName);
  void newMessage(Message message);
  List<User> getUsers();
  void userDisconnected(User user);
}
