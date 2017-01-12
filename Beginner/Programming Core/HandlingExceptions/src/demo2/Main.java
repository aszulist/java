package demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        File file = new File("test.txt");

        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.out.println("File not found: " + file.toString());
        }

        System.out.println("Finished!");

    }
}
