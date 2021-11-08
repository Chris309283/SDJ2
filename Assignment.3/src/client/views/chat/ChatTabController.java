package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;

public class ChatTabController implements ViewController
{

  @FXML private Label userNameLabel;
  @FXML private TextArea messageArea;
  @FXML private TextArea chatArea;
  @FXML private Button sendButton;

  private User receiver;
  private String messageContent;

  private ChatTabModel chatTabModel;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory, Stage stage, User receiver,
      Message initMessage)
  {
    messageContent = "";
    chatArea.setText(messageContent);
    setText(initMessage);
    this.chatTabModel = viewModelFactory.getChatTabModel();
    this.receiver = receiver;
    chatTabModel.addListener("NewMessage", this::onNewMessage);
    sendButton.disableProperty()
        .bind(Bindings.isEmpty(messageArea.textProperty()));
    if (receiver != null)
    {
      userNameLabel.setText(receiver.getUsername());
    }

    messageArea.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER)
      {
        sendButton(null);
      }
    });
  }

  private void setText(Message message)
  {
    if (message != null)
    {
      messageContent += "\n" + message.getSender().getUsername() + "> "
          + message.getMessage();
      chatArea.setText(messageContent);
    }
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    Message newMessage = (Message) propertyChangeEvent.getNewValue();
    if ((newMessage.getReceiver() == null) && receiver == null)
    {
      setText(newMessage); // Send to ALL
    }
    else if (newMessage.getReceiver() != null && receiver != null)
    {
      if (newMessage.getReceiver().equals(receiver) && newMessage.getSender()
          .equals(chatTabModel.getUser()))
      {
        setText(newMessage); // Send private if I sent
      }
      else if (newMessage.getReceiver().equals(chatTabModel.getUser())
          && newMessage.getSender().equals(receiver))
      {
        setText(newMessage); // Send private sent to me
      }

    }
  }

  public void sendButton(ActionEvent actionEvent)
  {
    if ((messageArea.getText() != null) && (!(messageArea.getText()
        .equals(""))))
    {
      chatTabModel.sendMessage(messageArea.getText(), receiver);
      messageArea.clear();
    }
  }
}
