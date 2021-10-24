package server.model.chat;

import shared.transferobjects.Message;
import shared.util.Subject;

public interface ChatModel extends Subject
{
  void newMessage(Message message);
}
