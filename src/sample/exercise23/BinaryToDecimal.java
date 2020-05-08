package sample.exercise23;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter binary value: ");
        String number = input.next();
        System.out.println("Decimal value " + bin2Dec(number));
    }

    public static int bin2Dec(String binaryString) {
        return bin2Dec(binaryString, binaryString.length() - 1);
    }

    private static int bin2Dec(String binaryString, int position) {
        if (position == -1)
            return 0;
        return binaryString.charAt(position) - '0' + bin2Dec(binaryString, position - 1) * 2;
    }
}
