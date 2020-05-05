package sample.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();
        System.out.println("The Fibonacci number at index " + index + " is " + fib(index));
    }

    private static int fib(int n) {
        int f0 = 0;
        int f1 = 1;

        for (int i = 1; i < n; i++) {
            int currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }
        return f1;
    }
}
