package com.ss.leetcode.august;

import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters {
    // https://leetcode.com/problems/find-common-characters/
    public List<String> commonChars(String[] words) {
        int[][] letters = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                letters[i][words[i].charAt(j) - 'a']++;
            }
        }
        List<String> commonChars = new LinkedList<>();

        for (int j = 0; j < 26; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {
                if (letters[i][j] < min) {
                    min = letters[i][j];
                }
            }
            if (min > 0) {
                for (int times = 0; times < min; times++) {
                    commonChars.add(String.valueOf((char)(j + 'a')));
                }
            }
        }
        return commonChars;
    }
}
