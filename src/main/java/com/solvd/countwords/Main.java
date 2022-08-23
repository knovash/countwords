package com.solvd.countwords;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws URISyntaxException, IOException {

        String text = Utils.getText("test.txt");
        Map<String, Integer> wordsCounted = CountWords.count(text);
        LOGGER.info(wordsCounted);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer count1, Integer count2) {
                return count2.compareTo(count1);
            }
        };

        List<String> wordsCountedSorted = wordsCounted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .map((w) -> w.toString())
                .peek((w) -> LOGGER.info("peek " + w))
                .collect(Collectors.toList());
        Utils.outText("words_counted_sorted.txt", wordsCountedSorted);


    }
}