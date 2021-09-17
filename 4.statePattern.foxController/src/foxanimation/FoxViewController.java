package foxanimation;

import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FoxViewController {
    public Group group;


    private static Image FOX_RUN;
    private static Image FOX_ATTACK;
    private static Image FOX_CROUCH;
    private static Image FOX_JUMP;
    private static Image FOX_IDLE;
    private static Image FOX_WALK;
    private static Image FOX_DEAD;

    private static final int WIDTH = 100; // width of one animation image, within the animation sheet
    private static final int HEIGHT = 100;
    private static final int OFFSET_X = 0; // don't know.
    private static final int OFFSET_Y = 0;

    // loading image animation sheets
    static {
        try {
            FOX_RUN = new Image(new FileInputStream("resources/img/FOX_RUN.png"));
            FOX_ATTACK = new Image(new FileInputStream("resources/img/FOX_ATTACK.png"));
            FOX_CROUCH = new Image(new FileInputStream("resources/img/FOX_CROUCH.png"));
            FOX_JUMP = new Image(new FileInputStream("resources/img/FOX_JUMP.png"));
            FOX_DEAD = new Image(new FileInputStream("resources/img/FOX_DEAD.png"));
            FOX_IDLE = new Image(new FileInputStream("resources/img/FOX_IDLE.png"));
            FOX_WALK = new Image(new FileInputStream("resources/img/FOX_WALK.png"));
        } catch (FileNotFoundException e) {}
    }

    public void init() {
        onIdle();
    }

    public void onIdle() {
        playAnimation(FOX_IDLE, -1);
    }

    public void onWalk() {
        playAnimation(FOX_WALK, -1);
    }

    public void onRun() {
        playAnimation(FOX_RUN, -1);
    }

    private void playAnimation(Image img, int iterations) {
        group.getChildren().clear();
        int COUNT = (int) (img.getWidth() / 100);
        int COLUMNS = (int) (img.getWidth() / 100);

        final ImageView imageView = new ImageView(img);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        // setting size of image
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        // how many times will this animation play?
        animation.setCycleCount(iterations);
        animation.play();
        group.getChildren().add(imageView);
    }

    public void onJump() {
        playAnimation(FOX_JUMP, 1);
    }

    public void onCrouch() {
        playAnimation(FOX_CROUCH, -1);
    }

    public void onAttack() {
        playAnimation(FOX_ATTACK, 1);
    }

    public void onDead() {
        playAnimation(FOX_DEAD, 1);
    }

}
