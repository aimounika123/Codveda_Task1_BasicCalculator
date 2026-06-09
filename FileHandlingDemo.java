import java.io.*;
import java.util.Scanner;

public class FileHandlingDemo {
    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        int lineCount = 0;
        int wordCount = 0;

        try {
            File file = new File(inputFile);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineCount++;

                String[] words = line.trim().split("\\s+");

                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            sc.close();

            FileWriter writer = new FileWriter(outputFile);
            writer.write("Number of Lines: " + lineCount + "\n");
            writer.write("Number of Words: " + wordCount + "\n");
            writer.close();

            System.out.println("Data processed successfully.");
            System.out.println("Results written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}