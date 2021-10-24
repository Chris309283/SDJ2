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

    mainViewModel.addListener("CREATE NEW TAB",this::checkNewTab);

    Tab allTab = new Tab("Everyone");
    tabPane.getTabs().add(allTab);
    viewHandler.openChatTab(allTab,null,null);
    allTab.closableProperty().setValue(false);

    userList.setOnMouseClicked(mouseEvent -> {
      if (mouseEvent.getClickCount()==2)
      {
        User userClicked = userList.getSelectionModel().getSelectedItem();
        if (!(userClicked.getID().equals(mainViewModel.getIdentity().getID())))
        {
          if (!(tabList.existTab(userClicked.getID())))
          {
            createTab(userClicked,null);
            selectionModel.select(tabList.getTab(userClicked.getID()));
          }
        }
      }
    });

    stage.setOnCloseRequest(new EventHandler<WindowEvent>()
    {
      @Override public void handle(WindowEvent windowEvent)
      {
        mainViewModel.userLeft();
        Platform.exit();
        System.exit(0);
      }
    });
  }

  private void createTab(User userClicked, Message message)
  {
   tabList.addTab(userClicked);
   tabPane.getTabs().add(tabList.getTab(userClicked.getID()));
   viewHandler.openChatTab(tabList.getTab(userClicked.getID()),userClicked,message);
   tabList.getTab(userClicked.getID()).setOnCloseRequest(event -> {
     tabList.removeTab(userClicked.getID());
   });
  }

  private void checkNewTab(PropertyChangeEvent propertyChangeEvent)
  {
    Message message = (Message) propertyChangeEvent.getNewValue();
    User userClicked = message.getSender();
    if (!(userClicked.getID().equals(mainViewModel.getIdentity().getID())))
    {
      Platform.runLater(()-> createTab(userClicked, message));
    }
    else
    {
      selectionModel.select(tabList.getTab(userClicked.getID()));
    }
  }

  private void setUserList()
  {

  }

  @Override public void reset()
  {

  }
}
