package sample.exercise21;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(dec2Bin(18));
    }

    public static String dec2Bin(int value) {
        if (value == 0)
            return "0";
        if (value == 1)
            return "1";
        return dec2Bin(value / 2) + (char) ('0' + value % 2);
    }
}
