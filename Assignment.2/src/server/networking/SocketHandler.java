package server.networking;

import server.model.chat.ChatModelManager;
import server.model.login.LoginModelManager;
import shared.transferobjects.Message;
import shared.transferobjects.Request;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketHandler implements Runnable
{
  private Socket socket;
  private ChatModelManager chatModelManager;
  private LoginModelManager loginModelManager;

  private ObjectOutputStream outputStream;
  private ObjectInputStream inputStream;

  public SocketHandler(Socket socket, ChatModelManager chatModelManager,
      LoginModelManager loginModelManager)
  {
    this.socket = socket;
    this.chatModelManager = chatModelManager;
    this.loginModelManager = loginModelManager;

    try
    {
      outputStream = new ObjectOutputStream(socket.getOutputStream());
      inputStream = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try {
      Request request = (Request) inputStream.readObject();
      switch (request.getType()) {
        case "LISTENER": {
          runListeners((String) request.getArg());
          break;
        }
        case "NEW USER": {
          runNewUser((String) request.getArg());
          break;
        }
        case "GET USERS": {
          runGetUsers();
          break;
        }
        case "NEW MESSAGE": {
          runNewMessage((Message) request.getArg());
          break;
        }
        case "USER LEFT": {
          runUserLeft((User) request.getArg());
          break;
        }
        default:
          throw new Exception("Command error...");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void runUserLeft(User user) throws IOException {
    loginModelManager.removeUser(user);
    outputStream.writeObject(new Request("USER LEFT", "COMMAND RECEIVED"));
  }


  private void runNewMessage(Message message) throws IOException {
    chatModelManager.newMessage(message);
    outputStream.writeObject(new Request("NEW MESSAGE", "MESSAGE RECEIVED"));
  }

  private void runGetUsers() throws IOException {
    outputStream.writeObject(new Request("GET USERS", loginModelManager.getUsers()));
  }

  private void runNewUser(String nickName) throws IOException {
    String ip = (((InetSocketAddress) socket.getRemoteSocketAddress()).getAddress()).toString().replace("/","");
    User newUser = new User(nickName, ip);
    loginModelManager.newUser(newUser);
    outputStream.writeObject(new Request("CONNECTED", newUser.copy()));
  }

  private void runListeners(String ID) {
    loginModelManager.addListener("USER LIST MODIFIED", this::onListModified);
    chatModelManager.addListener("NEW MESSAGE", event -> onNewMessage(event, ID) );
  }

  private void onNewMessage(PropertyChangeEvent event, String ID) {
    try {
      if (((Message) event.getNewValue()).getReceiver() == null) {
        outputStream.writeObject(new Request(event.getPropertyName(), event.getNewValue()));
      } else if (((Message) event.getNewValue()).getReceiver().getID().equals(ID)  ||
          ((Message) event.getNewValue()).getSender().getID().equals(ID))
        outputStream.writeObject(new Request(event.getPropertyName(), event.getNewValue()));
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  private void onListModified(PropertyChangeEvent event) {
    try {
      outputStream.writeObject(new Request(event.getPropertyName(), event.getNewValue()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
