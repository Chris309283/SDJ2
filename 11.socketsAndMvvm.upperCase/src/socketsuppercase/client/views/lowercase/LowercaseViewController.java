package socketsuppercase.client.views.lowercase;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import socketsuppercase.client.core.ViewHandler;
import socketsuppercase.client.core.ViewModelFactory;
import socketsuppercase.client.views.ViewController;

public class LowercaseViewController implements ViewController
{
    @FXML
    private TextField requestField;
    @FXML
    private TextField replyField;
    @FXML
    private Label errorLabel;

    private LowercaseViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.viewHandler = viewHandler;

        viewModel = vmf.getLowercaseViewModel();

        requestField.textProperty().bindBidirectional(this.viewModel.requestProperty());
        replyField.textProperty().bind(this.viewModel.replyProperty());
        errorLabel.textProperty().bind(this.viewModel.errorProperty());
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML
    private void onSubmitButton() {
        viewModel.convertToCamelCase();
    }

    public void onLogButton(ActionEvent actionEvent)
    {
        viewHandler.openLog();
    }
}
