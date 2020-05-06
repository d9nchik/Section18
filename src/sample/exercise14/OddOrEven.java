package sample.exercise14;

public class OddOrEven {
    public static void main(String[] args) {
        System.out.println("135 odd? " + isEven(135));
    }

    public static boolean isOdd(int x) {
        if (x > 1)
            return isEven(x - 1);
        return x != 0;
    }

    public static boolean isEven(int x) {
        if (x > 1)
            return isOdd(x - 1);
        return x != 1;
    }
}
