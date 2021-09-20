package uppercase.core;

import uppercase.view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private UppercaseViewModel uppercaseVM;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf= mf;
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (uppercaseVM == null)
    {
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    }
    return uppercaseVM;
  }
}
