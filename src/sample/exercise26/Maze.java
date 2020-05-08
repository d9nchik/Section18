package sample.exercise26;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Maze extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final Box[][] boxes = new Box[9][9];
    private final int[] changeX = {1, 0, -1, 0};
    private final int[] changeY = {0, 1, 0, -1};

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        borderPane.setCenter(gridPane);

        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = new Box();
                gridPane.add(boxes[i][j], j, i);
            }
        }

        Button find = new Button("Find Path");
        Button clear = new Button("Clear Path");
        HBox buttons = new HBox(find, clear);
        borderPane.setBottom(buttons);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);

        TextField textField = new TextField();
        textField.setAlignment(Pos.CENTER);
        borderPane.setTop(new StackPane(textField));

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 26");
        primaryStage.show();

        clear.setOnAction(e -> clearPath());

        find.setOnAction(e -> {
            if (makePath())
                textField.setText("path found");
            else
                textField.setText("path not found");
        });
    }

    private boolean makePath() {
        clearPath();
        return makePath(0, 0);
    }

    private void clearPath() {
        for (Box[] box : boxes)
            for (Box value : box)
                value.clearPath();
    }

    private boolean makePath(int i, int j) {
        if (calculateMarkedNeighbours(i, j) > 1)
            return false;
        boxes[i][j].showPath();
        if (i == 8 && j == 8)
            return true;

        for (int k = 0; k < changeX.length; k++) {
            final int nextX = i + changeX[k];
            final int nextY = j + changeY[k];
            if (nextX >= 0 && nextX < 9 && nextY >= 0 && nextY < 9 && !boxes[nextX][nextY].isMarked())
                if (makePath(nextX, nextY))
                    return true;
        }
        boxes[i][j].hidePath();
        return false;
    }

    private int calculateMarkedNeighbours(int i, int j) {
        int counter = 0;
        for (int k = 0; k < changeX.length; k++) {
            final int nextX = i + changeX[k];
            final int nextY = j + changeY[k];
            if (nextX >= 0 && nextX < 9 && nextY >= 0 && nextY < 9 && boxes[nextX][nextY].isPathPart())
                counter++;
        }
        return counter;
    }
}
