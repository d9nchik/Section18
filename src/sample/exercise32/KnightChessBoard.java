package sample.exercise32;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;
import java.util.Collections;

public class KnightChessBoard {
    private final boolean[][] field = new boolean[8][8];
    private final Polyline polyline = new Polyline();
    private int counter = 64;

    private static ArrayList<ChessPoint> getAvailableKnightMove(int x, int y) {
        int[] moveX = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

        ArrayList<ChessPoint> moves = new ArrayList<>();
        for (int i = 0; i < moveX.length; i++) {
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8)
                moves.add(new ChessPoint(newX, newY));
        }
        Collections.sort(moves);
        return moves;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public boolean knightAllBoard() {
        return knightAllBoard(0, 0);
    }

    public boolean knightAllBoard(int x, int y) {
        if (!field[x][y]) {
            field[x][y] = true;
            counter--;
        }

        for (Point2D point2D : getAvailableKnightMove(x, y)) {
            int currentX = (int) point2D.getX();
            int currentY = (int) point2D.getY();
            if (!field[currentX][currentY])
                if (knightAllBoard(currentX, currentY))
                    break;
        }
        if (counter != 0) {
            counter++;
            field[x][y] = false;
            return false;
        } else {
            polyline.getPoints().addAll(15 + 30.0 * x, 15 + 30.0 * y);
            return true;
        }
    }
}

class ChessPoint extends Point2D implements Comparable<ChessPoint> {
    public ChessPoint(double v, double v1) {
        super(v, v1);
    }

    private double distanceOfCenter() {
        return Math.pow(getX() - 3.5, 2) + Math.pow(getY() - 3.5, 2);
    }

    @Override
    public int compareTo(ChessPoint o) {
        return Double.compare(o.distanceOfCenter(), distanceOfCenter());
    }
}
