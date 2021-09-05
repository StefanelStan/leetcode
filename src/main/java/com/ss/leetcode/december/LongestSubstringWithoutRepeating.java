package com.ss.leetcode.december;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String string) {
        if (string.isEmpty()) {
            return 0;
        }
        if (string.length() == 1) {
            return 1;
        }

        int maxSequence = 0;
        ElasticWindow ew = new ElasticWindow();
        for (int i = 0; i < string.length(); i++) {
            maxSequence = Math.max(ew.addChar(string.charAt(i), i), maxSequence);
        }
        return maxSequence;
    }

    private static class ElasticWindow {
        private final int[][] window = new int[2][256];
        private int size = 0;

        public ElasticWindow() {
            Arrays.fill(window[0], -1);
            Arrays.fill(window[1], -1);
        }

        public void trimToChar(char c) {
            int cPos = window[1][c];
            for (int i = 0; i < window[0].length; i++) {
                if (window[1][i] <= cPos && window[1][i] >= 0) {
                    window[0][i] = -1;
                    window[1][i] = -1;
                    size--;
                }
            }
        }

        public int addChar(char c, int position) {
            if (containsChar(c)) {
                trimToChar(c);
            }
            window[0][c] = 1;
            window[1][c] = position;
            size++;
            return size;
        }

        private boolean containsChar(char c) {
            return window[0][c] == 1;
        }
    }




    public int lengthOfLongestSubstring2(String string) {
        if (string.isEmpty()) {
            return 0;
        }
        if (string.length() ==1) {
            return 1;
        }

        int longest = 0;
        Set<Character> tempSet = new HashSet<>();
        for (int i = 0; i < string.length() - 1; i++) {
            tempSet.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (!tempSet.add(string.charAt(j))) {
                    if (tempSet.size() > longest) {
                        longest = tempSet.size();
                    }
                    tempSet.clear();
                    break;
                }
            }
            if (tempSet.size() > longest) {
                longest = tempSet.size();
            }
            tempSet.clear();
        }
        return longest;
    }
}
