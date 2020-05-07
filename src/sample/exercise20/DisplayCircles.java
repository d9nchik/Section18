package sample.exercise20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DisplayCircles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Circles(), 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 20");
        primaryStage.show();
    }

    static class Circles extends StackPane {
        Circles() {
            paint();
            heightProperty().addListener(e -> paint());
            widthProperty().addListener(e -> paint());
        }

        protected void paint() {
            // Select three points in proportion to the pane size
            this.getChildren().clear(); // Clear the pane before redisplay

            displayCircles(Math.min(getWidth(), getHeight()) / 2 - 10);
        }

        private void displayCircles(double radius) {
            while (radius >= 5) {
                Circle circle = new Circle(0, 0, radius);
                circle.setStroke(Color.BLACK);
                circle.setFill(null);
                getChildren().add(circle);
                radius -= 5;
            }
        }
    }
}
