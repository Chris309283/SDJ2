package socketsuppercase.client.core;

import socketsuppercase.client.views.camelcase.CamelcaseViewModel;
import socketsuppercase.client.views.log.LogViewModel;
import socketsuppercase.client.views.lowercase.LowercaseViewModel;
import socketsuppercase.client.views.uppercase.UppercaseViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    private final CamelcaseViewModel camelcaseViewModel;
    private final LowercaseViewModel lowercaseViewModel;
    private final UppercaseViewModel uppercaseViewModel;
    private LogViewModel logViewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
        this.camelcaseViewModel = new CamelcaseViewModel(mf.getTextConverter());
        this.lowercaseViewModel = new LowercaseViewModel(mf.getTextConverter());
        this.uppercaseViewModel = new UppercaseViewModel(mf.getTextConverter());
    }

//    public UppercaseViewModel getUppercaseViewModel() {
//        if (uppercaseViewModel == null)
//            uppercaseViewModel = new UppercaseViewModel(mf.getTextConverter());
//        return uppercaseViewModel;
//    }

    public LogViewModel getLogViewModel() {
        return (logViewModel = logViewModel == null ?
                new LogViewModel(mf.getTextConverter()) :
                logViewModel);
    }

    public CamelcaseViewModel getCamelcaseViewModel()
    {
        return camelcaseViewModel;
    }

    public LowercaseViewModel getLowercaseViewModel()
    {
        return lowercaseViewModel;
    }

    public UppercaseViewModel getUppercaseViewModel()
    {
        return uppercaseViewModel;
    }
}
