package client.core;

import client.views.chat.ChatTabModel;
import client.views.login.LoginViewModel;
import client.views.main.MainViewModel;


public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private ChatTabModel chatTabModel;
  private LoginViewModel loginViewModel;
  private MainViewModel mainViewModel;


  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public ChatTabModel getChatTabModel()
  {
   if (chatTabModel == null)
   {
     chatTabModel = new ChatTabModel(modelFactory.getChatAppModel());
   }
   return chatTabModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    if (loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(modelFactory.getChatAppModel());
    }
    return loginViewModel;
  }


  public MainViewModel getMainViewModel()
  {
    if (mainViewModel == null)
    {
      mainViewModel = new MainViewModel(modelFactory.getChatAppModel());
    }
    return mainViewModel;
  }
}
