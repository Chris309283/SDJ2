package client.model;

import shared.transferobjects.User;
import shared.util.Subject;

import java.awt.image.BufferedImage;
import java.util.List;

public interface ChatAppModel extends Subject
{
  void newUser(String value);
  void newMessage(String text, User receiver);
  List<User> getUsers();
  void userLeft();
  User getIdentity();
}
