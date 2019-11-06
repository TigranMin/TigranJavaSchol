package com.sbt.javaschool.Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

//D:/Java/input.txt
//D:/Java/output.txt

public class MostPopularWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:/Java/input2.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:/Java/output2.txt"));

        ArrayList<String> list = new ArrayList<String>();
        String s;

        while (true){
            s = reader.readLine();
            if(s == null){
                break;
            }
            for (String word: s.split("\\s")) {
                list.add(word.toLowerCase());
            }
        }
        int maxFreq = 0;
        for (String word: list) {
            if(Collections.frequency(list, word) > maxFreq){
                maxFreq = Collections.frequency(list, word);
            }
        }

        TreeSet<String> set = new TreeSet<>();

        for (String word: list) {
            if(Collections.frequency(list, word) == maxFreq){
                set.add(word);
            }
        }
        for (String mostpopwords : set) {
            writer.write(mostpopwords);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
