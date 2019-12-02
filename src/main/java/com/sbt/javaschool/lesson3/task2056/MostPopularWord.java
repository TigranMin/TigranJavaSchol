package com.sbt.javaschool.lesson3.task2056;

import com.sbt.javaschool.lesson3.homeworkCollectionsAPI.Solution;

import java.io.IOException;
import java.util.*;

public class MostPopularWord {
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
