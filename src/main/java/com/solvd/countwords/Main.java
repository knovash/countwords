package com.solvd.countwords;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        String text = FileTool.getString("test.txt");
        Map<String, Integer> countedWords = CountWords.count(text);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer count1, Integer count2) {
                return count2.compareTo(count1);
            }
        };
        countedWords.entrySet().stream().sorted(Map.Entry.comparingByValue(comparator)).forEach(LOGGER::info);
    }
}