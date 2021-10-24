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
  private ViewHandler viewHandler;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory, Stage stage, User receiver,
      Message initMessage)
  {
    messageContent = "";
    chatArea.setText(messageContent);
    setText(initMessage);
    this.chatTabModel = viewModelFactory.getChatTabModel();
    this.receiver = receiver;
    chatTabModel.addListener("NEW MESSAGE", this::onNewMessage);
    sendButton.disableProperty()
        .bind(Bindings.isEmpty(messageArea.textProperty()));
    if (receiver==null)
    {
      userNameLabel.setText("Everyone");
    }
    else
    {
      userNameLabel.setText(receiver.getNickName());
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

    if (message!=null)
    {
      messageContent += "\n" + message.getSender().getNickName() + "> "
          + message.getContent();
      chatArea.setText(messageContent);
    }
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    Message message = (Message) propertyChangeEvent.getNewValue();
    setText(message);
  }

  @Override public void reset()
  {

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
