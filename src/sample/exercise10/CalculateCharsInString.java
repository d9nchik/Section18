package sample.exercise10;

import java.util.Scanner;

public class CalculateCharsInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String line = input.nextLine();
        System.out.print("Enter a char: ");
        char symbol = input.next().charAt(0);
        System.out.println("Number of char occurrence: " + count(line, symbol));
    }

    public static int count(String str, char a) {
        return helperForCount(str, str.length() - 1, a);
    }

    private static int helperForCount(String str, int position, char a) {
        if (position == -1)
            return 0;
        return helperForCount(str, position - 1, a) + (str.charAt(position) == a ? 1 : 0);
    }
}
