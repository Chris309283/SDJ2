package client.views.main;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.main.tools.TabList;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;

public class MainViewController implements ViewController
{
 @FXML private ListView<User> userList;
 @FXML private TabPane tabPane;

 private ViewHandler viewHandler;
 private MainViewModel mainViewModel;
 private TabList tabList;

 private SingleSelectionModel<Tab> selectionModel;

 @Override public void init(ViewHandler viewHandler,
     ViewModelFactory viewModelFactory, Stage stage, User receiver,
     Message initMessage)
 {
  this.viewHandler = viewHandler;
  this.mainViewModel = viewModelFactory.getMainViewModel();
  this.tabList = new TabList();
  userList.setItems(mainViewModel.getUsers());

  selectionModel=tabPane.getSelectionModel();

  mainViewModel.addListener("NewTab",this::checkNewTab);

  Tab allTab = new Tab("Everyone");
  tabPane.getTabs().add(allTab);
  viewHandler.openChatTab(allTab,null,null);
  allTab.closableProperty().setValue(false);

  userList.setOnMouseClicked(mouseEvent -> {
   if (mouseEvent.getClickCount()==2)
   {
    User userClicked = userList.getSelectionModel().getSelectedItem();
    if (!(userClicked.getId().equals(mainViewModel.getUser().getId())))
    {
     if (!(tabList.existTab(userClicked.getId())))
     {
      createTab(userClicked,null);
      selectionModel.select(tabList.getTab(userClicked.getId()));
     }
    }
   }
  });

  stage.setOnCloseRequest(new EventHandler<WindowEvent>()
  {
   @Override public void handle(WindowEvent windowEvent)
   {
    mainViewModel.userDisconnected();
    Platform.exit();
    System.exit(0);
   }
  });
 }

 private void checkNewTab(PropertyChangeEvent propertyChangeEvent)
 {
  Message message = (Message) propertyChangeEvent.getNewValue();
  User userClicked = message.getSender();
  if (!(userClicked.getId().equals(mainViewModel.getUser().getId())))
  {
   Platform.runLater(()-> createTab(userClicked, message));
  }
  else
  {
   selectionModel.select(tabList.getTab(userClicked.getId()));
  }
 }

 private void createTab(User userClicked, Message message)
 {
  tabList.addTab(userClicked);
  tabPane.getTabs().add(tabList.getTab(userClicked.getId()));
  viewHandler.openChatTab(tabList.getTab(userClicked.getId()),userClicked,message);
  tabList.getTab(userClicked.getId()).setOnCloseRequest(event -> {
   tabList.removeTab(userClicked.getId());
  });
 }
}
