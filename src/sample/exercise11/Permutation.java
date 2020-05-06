package sample.exercise11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Permutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the array size: ");

        int[] integers = new int[input.nextInt()];
        for (int i = 0; i < integers.length; i++)
            integers[i] = i + 1;
        displayAllPermutation(integers);
    }

    public static void displayAllPermutation(int[] integers) {
        displayAllPermutation(integers, 0);
    }

    private static void displayAllPermutation(int[] integers, int startPosition) {
        if (startPosition == integers.length - 1)
            System.out.println(Arrays.toString(integers));
        else
            for (int i = startPosition; i < integers.length; i++) {
                int temp = integers[i];
                integers[i] = integers[startPosition];
                integers[startPosition] = temp;
                displayAllPermutation(integers, startPosition + 1);
            }
    }
}
