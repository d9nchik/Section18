package sample.exercise24;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class KnightChessBoard {
    private static final boolean[][] field = new boolean[8][8];
    private static int counter = 64;

    public static void main(String[] args) {
        System.out.println("Was knight on all position? " + knightAllBoard());
    }

    private static ArrayList<Point2D> getAvailableKnightMove(int x, int y) {
        int[] moveX = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

        ArrayList<Point2D> moves = new ArrayList<>();
        for (int i = 0; i < moveX.length; i++) {
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8)
                moves.add(new Point2D(newX, newY));
        }
        return moves;
    }

    public static boolean knightAllBoard() {
        return knightAllBoard(0, 0);
    }

    public static boolean knightAllBoard(int x, int y) {
        if (!field[x][y]) {
            field[x][y] = true;
            counter--;
        }
        final String s = "Move to " + (char) (x + 'A') + (y + 1);
        System.out.println(s);
        for (Point2D point2D : getAvailableKnightMove(x, y)) {
            int currentX = (int) point2D.getX();
            int currentY = (int) point2D.getY();
            if (!field[currentX][currentY])
                if (knightAllBoard(currentX, currentY))
                    return true;
                else
                    System.out.println(s);
        }
        return counter == 0;
    }
}
