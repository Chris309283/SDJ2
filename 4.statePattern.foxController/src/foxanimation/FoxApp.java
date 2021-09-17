package foxanimation;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FoxApp extends Application {




    public void start(Stage primaryStage) {
     /*   primaryStage.setTitle("The Horse in Motion");

        final ImageView imageView = new ImageView(FOX_RUN);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(-1);
        animation.play();

//        primaryStage.setScene(new Scene(new Group(imageView)));
        primaryStage.setScene(new Scene(new Group(imageView)));
        primaryStage.show();*/
        new ViewHandler().start();
    }
}
