package com.sbt.javaschool.Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//D:/Java/input.txt
//D:/Java/output.txt

public class MostPopularWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:/Java/input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:/Java/output.txt"));

        ArrayList<String> list = new ArrayList<String>();
        String s;

        while (true){
            s = reader.readLine();
            if(s == null){
                break;
            }
            for (String word: s.split("\\s")) {
                list.add(word.toLowerCase());
                //System.out.println(word);
            }
        }
        int maxFreq = 0;
        for (String word: list) {
            if(Collections.frequency(list, word) > maxFreq){
                maxFreq = Collections.frequency(list, word);
                System.out.println( word + " " + maxFreq);
            }
        }
        for (String word: list) {
            if(Collections.frequency(list, word) == maxFreq){
                writer.write(word);
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
    }
}
