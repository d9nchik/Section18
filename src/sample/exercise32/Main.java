package sample.exercise32;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        GridPane gridPane = new GridPane();
        StackPane stackPane = new StackPane(gridPane);
        pane.setCenter(stackPane);

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                gridPane.add(new Box(i, j), j, i);


        Button solve = new Button("Solve");
        HBox button = new HBox(solve);
        pane.setBottom(button);
        button.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise 32");
        primaryStage.setScene(scene);
        primaryStage.show();

        solve.setOnAction(e -> {
            Box box = Box.getSelected();
            stackPane.getChildren().clear();
            KnightChessBoard knightChessBoard = new KnightChessBoard();
            knightChessBoard.knightAllBoard(box.getY(), box.getX());
            Polyline polyline = knightChessBoard.getPolyline();
            stackPane.getChildren().addAll(gridPane, polyline);
        });
    }
}
