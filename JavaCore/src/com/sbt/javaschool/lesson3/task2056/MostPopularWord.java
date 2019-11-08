package com.sbt.javaschool.lesson3.task2056;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MostPopularWord {
    public static void main(String[] args) throws IOException {
//        long start = System.currentTimeMillis();
        File input = new File("D:/Java/input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        HashMap<String, Integer> uniqueWords = new HashMap<>();
        while ((line = reader.readLine()) != null){
            for (String word: line.split("\\s+")) {
                if(uniqueWords.get(word) == null){
                    uniqueWords.put(word, 1);
                } else {
                    uniqueWords.put(word, uniqueWords.get(word) + 1);
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
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
    }
}
