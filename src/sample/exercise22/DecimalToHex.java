package sample.exercise22;

import java.util.Scanner;

public class DecimalToHex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter decimal value: ");
        int number = input.nextInt();
        System.out.println("Hex value " + dec2Hex(number));
    }

    public static String dec2Hex(int value) {
        if (value < 8 && value >= 0)
            return "" + value;
        return dec2Hex(value / 8) + (char) ('0' + value % 8);
    }
}
