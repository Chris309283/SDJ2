package view.uppercase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{
 @FXML private TextField requestField;
 @FXML private TextField replyField;
 @FXML private Label errorLabel;

 @FXML private void onSubmitButton(ActionEvent actionEvent)
  {
    System.out.println("Submit Pressed");
  }
}
