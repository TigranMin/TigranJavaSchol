package com.sbt.javaschool.Lesson_3.MostPopularWord;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

//D:/Java/input.txt
//D:/Java/output.txt

public class MostPopularWord {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader output = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader = new BufferedReader(new FileReader(input.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output.readLine()));

        ArrayList<String> list = new ArrayList<String>();
        String s;
        try {
            while (true){
                s = reader.readLine();
                if(s == null){
                    break;
                }
                for (String word: s.split("\\s+")) {
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
                    //System.out.println(word);
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
        catch (Exception e){
            reader.close();
            writer.close();
        }

    }
}
