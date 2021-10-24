package client.networking;

import shared.transferobjects.Message;
import shared.transferobjects.User;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{
 void startClient(User user);
 void newUser(String username);
 void newMessage(Message message);
 void userDisconnected(User username);
 List<User> getUsers();

}
