package core;

import view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseVM;

  public ViewModelFactory()
  {
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (uppercaseVM == null)
    {
      uppercaseVM = new UppercaseViewModel();
    }
    return uppercaseVM;
  }
}
