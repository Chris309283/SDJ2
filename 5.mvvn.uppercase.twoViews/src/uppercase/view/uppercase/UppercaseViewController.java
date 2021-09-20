package uppercase.view.uppercase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uppercase.core.ViewHandler;

public class UppercaseViewController
{
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Label errorLabel;

  private UppercaseViewModel viewModel;
  private ViewHandler viewHandler;

 @FXML public void onSubmitButton(ActionEvent actionEvent)
  {
    viewModel.convert();
  }

  public void init(ViewHandler viewHandler,UppercaseViewModel uppercaseVM)
  {
    this.viewHandler = viewHandler;
    this.viewModel = uppercaseVM;
    errorLabel.textProperty().bind(viewModel.errorProperty());
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
  }

 @FXML public void onShow(ActionEvent actionEvent)
  {
   viewHandler.openLogView();
  }
}
