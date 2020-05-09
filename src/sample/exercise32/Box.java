package sample.exercise32;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class Box extends Pane {
    private static final int SIDE_SQUARE = 30;
    private static final Image image = new Image(new File("src/sample/exercise32/horse.png").toURI().toString());
    private static Box selected;
    private final Rectangle rectangle = new Rectangle(0, 0, SIDE_SQUARE, SIDE_SQUARE);
    private final int x;
    private final int y;


    public Box(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.LIGHTGRAY);
        getChildren().addAll(rectangle);

        setOnMouseClicked(e -> userMark());
    }

    public static Box getSelected() {
        return selected;
    }

    private void userMark() {
        if (selected == this) {
            getChildren().clear();
            selected = null;
            getChildren().add(rectangle);
        } else {
            if (selected != null)
                selected.userMark();
            selected = this;
            getChildren().clear();
            getChildren().add(new ImageView(image));
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
