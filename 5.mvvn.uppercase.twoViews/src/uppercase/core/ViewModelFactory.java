package uppercase.core;

import uppercase.view.log.LogViewModel;
import uppercase.view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private UppercaseViewModel uppercaseVM;
  private LogViewModel logVM;

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

  public LogViewModel getLogVM()
  {
    if (logVM == null)
    {
      logVM = new LogViewModel(mf.getTextConverter());
    }
    return logVM;
  }
}
