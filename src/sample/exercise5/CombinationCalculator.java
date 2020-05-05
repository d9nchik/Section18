package sample.exercise5;

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
            return C(n, p-1)*(n-p+1)/p;
    }
}
