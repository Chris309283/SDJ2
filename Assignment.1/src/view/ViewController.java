package view;

import core.ViewHandler;
import core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf, int i);
}
