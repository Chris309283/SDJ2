package core;

import view.data.DataViewModel;
import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory mf;
  private TemperatureViewModel temperatureViewModel;
  private DataViewModel dataViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    if (this.temperatureViewModel == null)
    {
      this.temperatureViewModel = new TemperatureViewModel(
          mf.getTemperatureHubModel());
    }
    return temperatureViewModel;
  }

  public DataViewModel getDataViewModel()
  {
    if (this.dataViewModel == null)
    {
      this.dataViewModel = new DataViewModel(mf.getTemperatureHubModel());
    }
    return dataViewModel;
  }
}
