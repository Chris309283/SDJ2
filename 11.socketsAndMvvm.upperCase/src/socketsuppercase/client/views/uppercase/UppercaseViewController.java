package socketsuppercase.client.views.uppercase;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import socketsuppercase.client.core.ViewHandler;
import socketsuppercase.client.core.ViewModelFactory;
import socketsuppercase.client.views.ViewController;

public class UppercaseViewController implements ViewController
{
    @FXML private TextField requestField;
    @FXML private TextField replyField;
    @FXML private Label errorLabel;

    private ViewHandler viewHandler;
    private UppercaseViewModel viewModel;


    public void init(ViewHandler viewHandler, ViewModelFactory vmf){
        this.viewHandler = viewHandler;

        viewModel = vmf.getUppercaseViewModel();

        requestField.textProperty().bindBidirectional(viewModel.requestProperty());
        replyField.textProperty().bind(viewModel.replyProperty());
        errorLabel.textProperty().bind(viewModel.errorProperty());
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML private void onSubmitButton(){
        viewModel.convertToUpperCase();
    }

    public void onLogButton(ActionEvent actionEvent)
    {
        viewHandler.openLog();
    }
}
