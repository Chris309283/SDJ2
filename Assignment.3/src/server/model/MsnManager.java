package server.model;

import shared.transferobjects.Message;
import shared.transferobjects.User;
import shared.util.Subject;

import java.util.List;

public interface MsnManager extends Subject
{
  void newUser(User user);
  List<User> getUsers();
  void removeUser(String id);
  void newMessage(Message message);
}
