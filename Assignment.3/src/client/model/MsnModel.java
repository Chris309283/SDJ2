package client.model;

import shared.transferobjects.User;
import shared.util.Subject;

import java.util.List;

public interface MsnModel extends Subject
{
  void newUser(String username);
  void newMessage(String text, User receiver);
  List<User> getUsers();
  void userDisconnected();
  User getUser();
}
