package sample.exercise21;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter decimal value: ");
        int number = input.nextInt();
        System.out.println("Binary value " + dec2Bin(number));
    }

    public static String dec2Bin(int value) {
        if (value == 0 || value == 1)
            return "" + value;
        return dec2Bin(value / 2) + (char) ('0' + value % 2);
    }
}
