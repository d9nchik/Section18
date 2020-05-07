package sample.exercise22;

public class DecimalToHex {
    public static String dec2Hex(int value) {
        if (value == 0)
            return "";
        return dec2Hex(value / 8) + (char) ('0' + value % 8);
    }
}
