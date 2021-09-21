package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatchingInAnArray {
    // https://leetcode.com/problems/string-matching-in-an-array/
    public List<String> stringMatching(String[] words) {
        List<String> matches = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(a -> a.length()));
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    matches.add(words[i]);
                    break;
                }
            }
        }
        return matches;
    }
}
