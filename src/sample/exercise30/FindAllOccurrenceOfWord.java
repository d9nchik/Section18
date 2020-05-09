package sample.exercise30;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindAllOccurrenceOfWord {
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        if (args.length != 2) {
            System.out.println("Usage: java FindAllOccurrenceOfWord path word");
            System.exit(1);
        }

        // Display the size
        System.out.println("Occurs " + getSize(new File(args[0]), args[1]) + " times");
    }

    public static long getSize(File file, String word) {
        long size = 0; // Store the total size of all files
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i], word); // Recursive call
            }
        } else { // Base case
            try (Scanner input = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {
                while (input.hasNext()) {
                    String line = input.nextLine();
                    while (line.matches(".*" + word + ".*")) {
                        line = line.replaceFirst(word, "");
                        size++;
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            }
        }

        return size;
    }
}
