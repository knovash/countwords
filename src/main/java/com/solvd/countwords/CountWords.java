package com.solvd.countwords;

import java.util.*;

public class CountWords {

    public static Map<String, Integer> count(String text) {

        String[] words = text.split(",\\s+|\\s+|:\\s+|\\.\\s+|\\)\\s+|\\s+\\(");
        Map<String, Integer> unicWords = new HashMap<>();
        for (String word : words) {
            unicWords.put(word, Collections.frequency(List.of(words), word));
        }
        return unicWords;
    }
}
