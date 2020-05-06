package sample.exercise6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the array size: ");
        int[] x = new int[input.nextInt()];
        System.out.print("Enter the limits: ");
        randomFillSortedArray(x, 0, x.length - 1, input.nextInt(), input.nextInt());
        System.out.println(Arrays.toString(x));
    }

    public static void randomFillSortedArray
            (int[] x, int l, int r, int a, int b) {
        if (r < l)
            return;
        x[l] = new Random().nextInt(b - a + 1) + a;
        randomFillSortedArray(x, l + 1, r, x[l], b);
    }
}
