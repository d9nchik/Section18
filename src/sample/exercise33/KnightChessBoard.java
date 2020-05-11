package sample.exercise33;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;
import java.util.Collections;

public class KnightChessBoard {
    private final boolean[][] field = new boolean[8][8];
    private final Polyline polyline = new Polyline();

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


    public boolean knightAllBoard(int x, int y) {
        if (x == ChessPoint.getSearchedPointX() && y == ChessPoint.getSearchedPointY()) {
            polyline.getPoints().addAll(15 + 30.0 * y, 15 + 30.0 * x);
            return true;
        }

        if (!field[x][y]) {
            field[x][y] = true;
        }

        for (Point2D point2D : getAvailableKnightMove(x, y)) {
            int currentX = (int) point2D.getX();
            int currentY = (int) point2D.getY();
            if (!field[currentX][currentY])
                if (knightAllBoard(currentX, currentY)) {
                    polyline.getPoints().addAll(15 + 30.0 * y, 15 + 30.0 * x);
                    return true;
                }
        }
        field[x][y] = false;
        return false;
    }
}

class ChessPoint extends Point2D implements Comparable<ChessPoint> {
    private static int searchedPointX;
    private static int searchedPointY;

    public ChessPoint(double v, double v1) {
        super(v, v1);
    }

    public static int getSearchedPointX() {
        return searchedPointX;
    }

    public static void setSearchedPointX(int searchedPointX) {
        if (searchedPointX >= 0 && searchedPointX < 8)
            ChessPoint.searchedPointX = searchedPointX;
    }

    public static int getSearchedPointY() {
        return searchedPointY;
    }

    public static void setSearchedPointY(int searchedPointY) {
        if (searchedPointY >= 0 && searchedPointY < 8)
            ChessPoint.searchedPointY = searchedPointY;
    }

    public static void setSearchedPoint(int searchedPointX, int searchedPointY) {
        ChessPoint.setSearchedPointX(searchedPointX);
        ChessPoint.setSearchedPointY(searchedPointY);
    }

    private double distanceOfCenter() {
        return (Math.pow(getX() - searchedPointX, 2) + Math.pow(getY() - searchedPointY, 2));
    }

    @Override
    public int compareTo(ChessPoint o) {
        return Double.compare(distanceOfCenter(), o.distanceOfCenter());
    }
}
