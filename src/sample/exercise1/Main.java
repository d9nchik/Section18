package sample.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        System.out.print("Enter first word: ");
        String word1 = input.next();
        System.out.print("Enter second word: ");
        String word2 = input.next();

        System.out.println("Are these words anagram? "+ areAnagrams(word1, word2));
    }

    private static boolean areAnagrams(String word1, String word2){
        if(word1.length()!=word2.length())
            return false;
        if (word1.length()==0)
            return true;
        return areAnagrams(word1.replaceFirst(word2.charAt(0)+"", ""), word2.substring(1));
    }
}
