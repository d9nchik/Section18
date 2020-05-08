package sample.exercise27;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class KochSnowflake extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
        TextField tfOrder = new TextField();
        tfOrder.setOnAction(
                e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    static class SierpinskiTrianglePane extends Pane {
        private int order = 0;

        SierpinskiTrianglePane() {
        }

        /**
         * Set a new order
         */
        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        protected void paint() {
            // Select three points in proportion to the pane size
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 30);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 30);

            this.getChildren().clear(); // Clear the pane before redisplay

            displayTriangles(order, p1, p2);
            displayTriangles(order, p3, p1);
            displayTriangles(order, p2, p3);
        }

        private void displayTriangles(int order, Point2D p1,
                                      Point2D p2) {
            if (order == 0) {
                // Draw a line
                getChildren().add(new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
            } else {
                // Get the midpoint on each edge in the triangle
                Point2D p3 = new Point2D((2 * p1.getX() + p2.getX()) / 3, (2 * p1.getY() + p2.getY()) / 3);
                Point2D p4 = new Point2D((2 * p2.getX() + p1.getX()) / 3, (2 * p2.getY() + p1.getY()) / 3);
                Line line1 = new Line(p1.getX(), p1.getY(), p3.getX(), p3.getY());
                Line line2 = new Line(p2.getX(), p2.getY(), p4.getX(), p4.getY());
                Line line3 = new Line(p1.getX(), p1.getY(), p4.getX(), p4.getY());
                line3.setRotate(60);
                Point2D p5 = line3.getLocalToSceneTransform().transform(p4);

                // Recursively display three triangles
                displayTriangles(order - 1, p5, p4);
                displayTriangles(order - 1, p3, p5);
                displayTriangles(order - 1, p1, p3);
                displayTriangles(order - 1, p4, p2);
            }
        }

        public void increaseOrder() {
            order++;
            paint();
        }

        public void decreaseOrder() {
            order = order < 1 ? 0 : order - 1;
            paint();
        }
    }
}

