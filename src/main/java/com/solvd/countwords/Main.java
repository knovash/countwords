package com.solvd.countwords;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {



        String fileName = "test.txt";
        if (args.length > 0) {
            System.out.println("get text from file: " + args);
            fileName = args.toString();
        } else {
            System.out.println("get text from default file test.txt");
        }

        String text = FileTool.getString(fileName);
        Map<String, Integer> countedWords = CountWords.count(text);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer count1, Integer count2) {
                return count2.compareTo(count1);
            }
        };

        List<String> countedWordsListSort = countedWords.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .map((w) -> w.toString())
                .peek((e) -> LOGGER.info("peek " + e))
                .collect(Collectors.toList());
        FileTool.putList("countedwords.txt", countedWordsListSort);
    }
}