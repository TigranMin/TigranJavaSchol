package com.sbt.javaschool.lesson11.part1;

import com.sbt.javaschool.lesson3.homeworkCollectionsAPI.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Map<String, Integer> uniqueWords = Solution.textToMap("D:/Java/input.txt");
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
