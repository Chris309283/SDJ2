package client.core;

import client.views.chat.ChatTabModel;
import client.views.login.LoginViewModel;
import client.views.main.MainViewModel;

public class ViewModelFactory
{
  private MainViewModel mainViewModel;
  private LoginViewModel loginViewModel;
  private ChatTabModel chatTabModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    this.mainViewModel = new MainViewModel(modelFactory.getMsnModel());
    this.loginViewModel = new LoginViewModel(modelFactory.getMsnModel());
    this.chatTabModel = new ChatTabModel(modelFactory.getMsnModel());
  }

  public MainViewModel getMainViewModel()
  {
    return mainViewModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    return loginViewModel;
  }

  public ChatTabModel getChatTabModel()
  {
    return chatTabModel;
  }
}
