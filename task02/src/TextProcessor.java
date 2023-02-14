import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextProcessor{
    public static void main(String[] args) throws IOException {

        Path p = Paths.get(args[0]);
        File f = p.toFile();

        Map<String, Integer> wordFreq = new HashMap<>();

        // Open a file as input stream
        InputStream is = new FileInputStream(f);
        // Convert the input stream to a reader byte -> char (2 bytes)
        InputStreamReader isr = new InputStreamReader(is);
        // Read whole lines
        BufferedReader br = new BufferedReader(isr);
        String line;
        int numWords = 0;
        while ((line = br.readLine()) != null) {
            System.out.printf("> %s\n", line.toUpperCase());
            String[] words = line.split(" ");
            numWords += words.length;
            // Iterate the all the words in the line
            for (String w: words) {
                String t = w.trim().toLowerCase();
                 t = t.replaceAll("\\p{P}", "");

                 //find out what are the unique words in the text
                 HashSet<String> uniqueWords = new HashSet<String>(Arrays.asList(t));
                 
               
            }
        }

        // Get a list of all the words
        Set<String> words = wordFreq.keySet();
        for (String w: words) {
            int count = wordFreq.get(w);
            System.out.printf(": %s = %d\n", w, count);
        }

        System.out.printf("Number of words: %d\n", numWords);
        System.out.printf("Number of unique words: %d\n", words.size());
        System.out.printf("Percentage of unique words: %f\n", words.size()/(float)numWords);

        br.close();
        isr.close();
        is.close();

        
    }
}