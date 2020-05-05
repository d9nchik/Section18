package sample.exercise3;

public class Main {
    public static void main(String[] args) {
        System.out.println(dec2b(0.625, 3, 10));
    }

    public static double dec2b(double x, int b,
                             int n) {
        if (x>0&&x<1&&n>0){
            x*=b;
            return ((int)x + dec2b(x%1, b, n-1))/10;
        }
        return 0;
    }
}
