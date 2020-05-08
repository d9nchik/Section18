package sample.exercise25;

public class StringPermutation {
    public static void main(String[] args) {
        displayPermutation("abc");
    }

    public static void displayPermutation(String s) {
        displayPermutation("", s);
    }

    public static void displayPermutation(String s1, String s2) {
        if (s2.length() == 0)
            System.out.println(s1);
        else
            for (int i = 0; i < s2.length(); i++)
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));

    }
}
