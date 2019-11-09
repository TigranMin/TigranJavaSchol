package lesson3.task2056;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MostPopularWord {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        File input = new File("D:/Java/input.txt");
        Map<String, Integer> uniqueWords = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    uniqueWords.merge(word, 1, Integer::sum);
                }
            }
        }
        int maxFreq = Collections.max(uniqueWords.values());
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> pair: uniqueWords.entrySet()) {
            if(pair.getValue() == maxFreq){
                list.add(pair.getKey());
            }
        }
        list.sort(Comparator.naturalOrder());
        for (String s: list) {
            System.out.println(s);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
