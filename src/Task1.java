import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Task1 {
    static Set<String> readWordsFromFile(String words_filename){
        Set<String> words = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(words_filename))) {
            String word;
            while ((word = br.readLine()) != null) {
                words.add(word);
            }
        } catch (IOException e) {
            System.out.println("Error message: "+ e.getMessage());
        }
        return words;
    }
    static Map<String, Integer> countWordsInFile(String text_filename, Set<String> words) {
        Map<String, Integer> counts = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(text_filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : words) {
                    int index = line.indexOf(word);
                    while (index != -1) {
                        counts.put(word, counts.getOrDefault(word, 0) + 1);
                        index = line.indexOf(word, index + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error message: "+ e.getMessage());
        }
        return counts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Word path: D:\\Education\\2-course\\Java\\jlab4-ValeriiSanduliak\\files\\word.txt");
        System.out.print("Input wordsFile path:");
        String words_filename = in.next();
        File words_file = new File(words_filename);
        while (!words_file.exists()) {
            System.out.print("File not found. Input wordsFile path:");
            words_filename = in.next();
            words_file = new File(words_filename);
        }
        System.out.println("-----------------------------------");
        System.out.println("Text path: D:\\Education\\2-course\\Java\\jlab4-ValeriiSanduliak\\files\\text.txt");
        System.out.print("Input wordFile path:");
        String text_filename = in.next();
        File text_file = new File(text_filename);
        while (!text_file.exists()) {
            System.out.print("File not found. Input textFile path:");
            text_filename = in.next();
            text_file = new File(text_filename);
        }
        Set<String> words = readWordsFromFile(words_filename);
        Map<String, Integer> countsWord = countWordsInFile(text_filename, words);
        Map<String,Integer> reversCountWord = new TreeMap<>(Comparator.reverseOrder());
        reversCountWord.putAll(countsWord);
        for(Map.Entry<String,Integer> i : reversCountWord.entrySet()){
            System.out.println(i.getKey()+" : "+i.getValue());
        }

        System.out.println("-----------------------------------");
        System.out.println("Text path: D:\\Education\\2-course\\Java\\jlab4-ValeriiSanduliak\\files\\output.txt");
        System.out.print("Input output file path:");
        String output_filename = in.next();
        File output_file = new File(output_filename);
        while (!output_file.exists()) {
            System.out.print("File not found. Input outputFile path:");
            output_filename = in.next();
            output_file = new File(output_filename);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output_file))) {
            for (Map.Entry<String, Integer> i : countsWord.entrySet()) {
                bw.write(i.getKey() + " : " + i.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error message: "+ e.getMessage());
        }
    }
}