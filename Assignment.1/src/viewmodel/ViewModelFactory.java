package viewmodel;

import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
private ModelFactory mf;
private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    if (this.temperatureViewModel==null)
    {
      this.temperatureViewModel = new TemperatureViewModel(mf.getTemperatureHubModel());
    }
   return temperatureViewModel;
  }
}
