package server.model.login;

import shared.transferobjects.User;
import shared.util.Subject;

import java.util.List;

public interface LoginModel extends Subject
{
  void newUser(User user);
  List<User> getUsers();
  void removeUser(User user);
}
