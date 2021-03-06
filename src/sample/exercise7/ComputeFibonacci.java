package sample.exercise7;

import java.util.Scanner;

public class ComputeFibonacci {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index "
                + index + " is " + fib(index));
        System.out.println("Number of times the fib method is called: " + fibonacciUseTime);
    }

    private static int fibonacciUseTime = 0;

    /**
     * The method for finding the Fibonacci number
     */
    public static long fib(long index) {
        fibonacciUseTime++;
        if (index == 0) // Base case
            return 0;
        else if (index == 1) // Base case
            return 1;
        else // Reduction and recursive calls
            return fib(index - 1) + fib(index - 2);
    }
}
