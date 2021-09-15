package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    // https://leetcode.com/problems/occurrences-after-bigram/
    public String[] findOcurrences(String text, String first, String second) {
        List<String> occurances = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length -2; i++) {
            if (words[i].equals(first) && words[i+1].equals(second)) {
                occurances.add(words[i+2]);
            }
        }
        return occurances.toArray(new String[0]);
    }
}
