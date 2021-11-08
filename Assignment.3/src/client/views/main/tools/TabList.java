package client.views.main.tools;

import javafx.scene.control.Tab;
import shared.transferobjects.User;

import java.util.ArrayList;
import java.util.List;

public class TabList
{
  private class userTab
  {
    private String id;
    private Tab tab;

    public userTab(String id, String username)
    {
      this.tab = new Tab(username);
      this.id = id;
      tab.setText(username);
    }

    public String getId()
    {
      return id;
    }

    public Tab getUserTab()
    {
      return tab;
    }
  }

  private List<userTab> tabList;

  public TabList()
  {
    this.tabList = new ArrayList<>();
  }

  public Tab getTab(String id)
  {
    for (userTab userTab : tabList)
    {
      if (userTab.getId().equals(id))
      {
        return userTab.getUserTab();
      }
    }
    return null;
  }

  public boolean existTab(String id)
  {
    return !(getTab(id) == null);
  }

  public void addTab(User user)
  {
    if (!existTab(user.getId()))
    {
      userTab userTab = new userTab(user.getId(), user.getUsername());
      tabList.add(userTab);
    }
  }

  public void removeTab(String id)
  {
    tabList.removeIf(userTab -> userTab.getId().equals(id));
  }
}
