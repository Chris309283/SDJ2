package view;

import viewmodel.ViewHandler;
import viewmodel.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf);
  void reset();
}
