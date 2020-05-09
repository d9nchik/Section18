package sample.exercise29;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        // Display the size
        showStructure(new File(directory));
    }

    public static void showStructure(File file) {
        showStructure(file, 0);
    }

    public static void showStructure(File file, int order) {
        for (int i = 0; i < order; i++)
            System.out.print("\t");
        System.out.println("+--" + file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++)
                showStructure(files[i], order + 1); // Recursive call
        }
    }
}
