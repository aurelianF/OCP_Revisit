package OCP_Revisit.IO_Java8.filecopy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BasicBufferedIOCharTest {

    public static List<String> readFile(File source) {
        List<String> lines = new ArrayList<>();

        // Implement character-based reading logic here, e.g., using BufferedReader.
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (java.io.IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return lines;
    }

    public static void writeFile(File destination, List<String> lines) {
        // Implement character-based writing logic here, e.g., using BufferedWriter.
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(destination))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (java.io.IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inPath = "IO_Java8/filecopy/papa.txt";
        String outPath = "IO_Java8/filecopy/papa_out.txt";

        // Implement character-based buffered I/O operations here.
        File sourceFile = new File(inPath);
        File destinationFile = new File(outPath);

        List<String> lines = readFile(sourceFile);
        writeFile(destinationFile, lines);

        System.out.println("File copy completed from " + sourceFile.getAbsolutePath() + " to "
                + destinationFile.getAbsolutePath());
        System.out.println("Number of lines copied: " + lines.size());
        // Note: Ensure that source.txt exists and contains some text for testing.
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist. Please create 'source.txt' with some content.");
        }
    }
}
