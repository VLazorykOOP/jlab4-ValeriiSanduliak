import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Task1 {

    static String[] readWordF(String words_filename){
    ArrayList<String> word = new ArrayList<String>();
    try {
        BufferedReader reader = new BufferedReader(new FileReader(words_filename));
        String line;
        while ((line = reader.readLine()) != null) {
            word.add(line);
        }
        reader.close();
    }
    catch (IOException ex)
    {
        System.out.println("Error read file");
    }
     LinkedHashSet<String> uniqueNumbers = new LinkedHashSet<>(word);
     ArrayList<String> result = new ArrayList<String>(uniqueNumbers);
     return result.toArray(new String[result.size()]);
    }
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in); // об'єкт для введення даних

            String words_file = "D:\\Education\\2-course\\Java\\jlab4-ValeriiSanduliak\\files\\word.txt";

            //System.out.print("Введіть назву файлу:");
            //String fileName = in.next();
            String fileName = "D:\\Education\\2-course\\Java\\jlab4-ValeriiSanduliak\\files\\text.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            ArrayList<String> lines = new ArrayList<String>();
            while ((line = reader.readLine()) != null) // читання рядків з файлу
            {
                lines.add(line);
            }
            reader.close();
           for(String c : lines){
               System.out.println(c);
           }
           String[] words = readWordF(words_file);
           Arrays.sort(words,Collections.reverseOrder());
           for(String c: words){
               System.out.println(c);
           }

        }
        catch (FileNotFoundException ex) {
            System.out.println("Файл не знайдено");
        }
        catch (Exception ex) {
            System.out.println("Помилка!!!");
        }
    }
}
