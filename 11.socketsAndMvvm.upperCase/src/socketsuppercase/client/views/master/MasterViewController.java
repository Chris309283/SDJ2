package socketsuppercase.client.views.master;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import socketsuppercase.client.core.ViewHandler;
import socketsuppercase.client.core.ViewModelFactory;
import socketsuppercase.client.views.ViewController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MasterViewController implements ViewController
{
    public AnchorPane mainAnchorPane;
    public ComboBox<String> toolCmbBox;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        toolCmbBox.getItems().addAll("UpperCase", "CamelCase", "LowerCase");
        toolCmbBox.valueProperty().addListener((observableValue, oldValue, selectedViewName) -> {
            Parent root;
            try {
                Method method = viewHandler.getClass().getMethod("get"+selectedViewName+"View");
                root = (Parent)method.invoke(viewHandler);
                mainAnchorPane.getChildren().clear();
                mainAnchorPane.getChildren().add(root);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        });
    }

    @Override
    public void reset() {
        // nothing to reset
    }
}
