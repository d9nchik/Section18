package sample.exercise31;

import java.io.*;
import java.util.Scanner;

public class ReplaceAllOccurrenceOfWord {
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        if (args.length != 3) {
            System.out.println("Usage: java FindAllOccurrenceOfWord path oldWord newWord");
            System.exit(1);
        }

        // Display the size
        replaceAllWords(new File(args[0]), args[1], args[2]);
        System.out.println("All words are replaced");
    }

    public static void replaceAllWords(File file, String oldWord, String newWord) {
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                replaceAllWords(files[i], oldWord, newWord); // Recursive call
            }
        } else { // Base case
            File outFile = new File("temp.txt");
            try (Scanner input = new Scanner(new BufferedInputStream(new FileInputStream(file)));
                 PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(outFile)))) {
                while (input.hasNext()) {
                    output.println(input.nextLine().replaceAll(oldWord, newWord));
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            }
            copyingOfFile(file, outFile);
        }
    }

    private static void copyingOfFile(File sourceFile, File outputFile) {
        if (!sourceFile.delete())
            System.out.println("Problem with deleting");
        if (!outputFile.renameTo(sourceFile))
            System.out.println("Problem with copying");
    }
}
