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

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        borderPane.setCenter(gridPane);

        Box[][] boxes = new Box[9][9];

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
        borderPane.setTop(new StackPane(textField));

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 26");
        primaryStage.show();
    }
}
