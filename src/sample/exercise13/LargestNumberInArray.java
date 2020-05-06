package sample.exercise13;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LargestNumberInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 8 elements: ");
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++)
            array[i] = input.nextInt();
        System.out.println(Arrays.toString(array));
        System.out.println("Max = " + findLargest(array));
    }

    private static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = random.nextInt(100);
        return array;
    }

    public static int findLargest(int[] array) {
        return findLargest(array, array.length - 1);
    }

    public static int findLargest(int[] array, int high) {
        if (high == 0)
            return array[0];
        final int largest = findLargest(array, high - 1);
        return Math.max(largest, array[high]);
    }
}
