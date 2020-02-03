package com.sbt.javaschool.lesson3.homeworkCollectionsAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(numberOfUniqueWords("D:/Java/input.txt"));
        sortedUniqueWords("D:/Java/input.txt");
        wordCounter("D:/Java/input.txt");
        reversedOrderText("D:/Java/input.txt");
        getLineByNumber("D:/Java/input.txt", 7);

    }

    public static Map<String, Integer> textToMap(String pathname) throws IOException {
        File input = new File(pathname);
        Map<String, Integer> uniqueWords = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    uniqueWords.merge(word, 1, Integer::sum);
                }
            }
        }
        return uniqueWords;
    }

    public static int numberOfUniqueWords(String pathname) throws IOException {
        return textToMap(pathname).size();
    }

    public static void sortedUniqueWords(String pathname) throws IOException {
        List<String> list = new ArrayList<>(textToMap(pathname).keySet());
        Comparator<String> comparator = Comparator.comparing(String::length);
        comparator = comparator.thenComparing(string -> string.toLowerCase());
        list.sort(comparator);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void wordCounter(String pathname) throws IOException {
        Map<String, Integer> map = textToMap(pathname);
        map.forEach((s, integer) -> System.out.println(s + " - " + integer));
    }

    public static void reversedOrderText(String pathname) throws IOException {
        File input = new File(pathname);
        List<String> list;
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            list = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                list.add(0, line);
            }
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static void getLineByNumber(String pathname, int lineNumber) throws IOException {
        File input = new File(pathname);
        List<String> list;
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            list = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            System.out.println(list.get(lineNumber - 1));
        }
    }
}
