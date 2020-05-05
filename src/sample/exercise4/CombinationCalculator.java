package sample.exercise4;

import java.util.Scanner;

public class CombinationCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        long n = input.nextInt();
        System.out.print("Enter p: ");
        long p = input.nextInt();

        System.out.println("C = "+C(n, p));
    }

    public static long C(long n, long p){
        if (n==p||p==0)
            return 1;
        else
            return C(n-1, p)+C(n-1, p-1);
    }
}
