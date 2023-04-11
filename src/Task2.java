import java.io.*;
import java.util.*;

public class Task2 {
    public static void task2() {
        System.out.println("----------------------------");
        System.out.println("\t\tTask2 : ");
        System.out.println("----------------------------");
        Scanner in = new Scanner(System.in);
        System.out.println("Text path: D:\\Education\\2-course\\Java\\jlab4-ValeriiSanduliak\\files\\text2.txt");
        System.out.print("Input text file path:");
        String text_filename = in.next();
        File text_file = new File(text_filename);
        while (!text_file.exists()) {
            System.out.print("File not found. Input text file path:");
            text_filename = in.next();
            text_file = new File(text_filename);
        }
        System.out.println("-----------------------------------");
        System.out.println("Output path: D:\\Education\\2-course\\Java\\jlab4-ValeriiSanduliak\\files\\output2.txt");
        System.out.print("Input output file path:");
        String output_filename = in.next();
        File output_file = new File(output_filename);
        while (!output_file.exists()) {
            System.out.print("File not found. Create a new file? (y/n):");
            String answer = in.next();
            if (answer.equalsIgnoreCase("y")) {
                try {
                    output_file.createNewFile();
                    System.out.println("File output created!!");
                } catch (IOException e) {
                    System.out.println("Error message: " + e.getMessage());
                }
            } else {
                System.out.print("Input output file path:");
                output_filename = in.next();
                output_file = new File(output_filename);
            }
        }
        List<String> wordL = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(text_filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordL.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output_filename))) {
            for (String word : wordL) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
        System.out.println("End!!!");
    }
}
