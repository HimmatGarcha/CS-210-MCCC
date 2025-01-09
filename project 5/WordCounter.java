import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
    // creates a scanner object for the user to input
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the name of the text file? ");
        String filename = scanner.nextLine();
   // creates the tree map to store word count
        Map<String, Integer> wordCounts = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
   // creates the pattern which is used to filter the list for matching words     
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
   // scanner obj for the file input
        try (Scanner fileScanner = new Scanner(new File(filename))) {
   // reads file line by line for each occurence of a stored word or a new word        
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                while (lineScanner.findInLine(pattern) != null) {
                    String word = lineScanner.match().group().toLowerCase();
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return;
        }
// prints word count
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
