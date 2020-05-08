package sample.exercise26;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Box extends Pane {
    Rectangle rectangle = new Rectangle(0, 0, 20, 20);
    Line line1 = new Line(0, 0, 20, 20);
    Line line2 = new Line(0, 20, 20, 0);

    public Box() {
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.LIGHTGRAY);
        line1.setStroke(null);
        line2.setStroke(null);
        getChildren().addAll(rectangle, line1, line2);

        setOnMouseClicked(e -> userMark());
    }

    public void clear() {
        rectangle.setFill(Color.WHITE);
        line1.setStroke(null);
        line2.setStroke(null);
    }

    public void showPath() {
        rectangle.setFill(Color.SANDYBROWN);
    }

    public void hidePath() {
        rectangle.setFill(Color.WHITE);
    }

    private void userMark() {
        if (line1.getStroke() == null) {
            line1.setStroke(Color.BLACK);
            line2.setStroke(Color.BLACK);
        } else {
            line1.setStroke(null);
            line2.setStroke(null);
        }
    }

    public boolean isMarked() {
        return rectangle.getFill().equals(Color.SANDYBROWN) || line1.getFill() != null;
    }

    public boolean isPathPart() {
        return rectangle.getFill().equals(Color.SANDYBROWN);
    }
}
