package sample.exercise9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sting: ");
        final String line = input.nextLine();
        System.out.print("Reversed string: ");
        reverseDisplay(line);
    }

    public static void reverseDisplay(String value) {
        helperForReverseDisplay(value, value.length() - 1);
    }

    private static void helperForReverseDisplay(String value, int position) {
        if (position == 0)
            System.out.println(value.charAt(0));
        else {
            System.out.print(value.charAt(position));
            helperForReverseDisplay(value, position - 1);
        }
    }
}
