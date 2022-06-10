package com.ss.leetcode.LC2020.december;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        FlexibleWindow fw = new FlexibleWindow(s.toCharArray());
        fw.process();
        return fw.getMaxSize();
    }

    private static class FlexibleWindow {
        int[] positions = new int[256];
        char[] chars;
        int maxSize;
        private int size;
        private int startPoint = -1;
        public FlexibleWindow(char[] chrs) {
            Arrays.fill(positions, -1);
            this.chars = chrs;
        }

        public void process() {
            for (int i = 0; i < chars.length; i++) {
                if (positions[chars[i]] == -1) {
                    positions[chars[i]] = i;
                    size++;
                    maxSize = Math.max(size, maxSize);
                    if (startPoint == -1) {
                        startPoint = i;
                    }
                } else {
                    trimToSize(positions[chars[i]]);
                    positions[chars[i]] = i;
                    size++;
                    maxSize = Math.max(size, maxSize);
                    if (startPoint == -1) {
                        startPoint = i;
                    }
                }
            }
        }

        public int getMaxSize() {
            return maxSize;
        }

        private void trimToSize(int point) {
            for (int i = startPoint; i <= point; i++) {
               positions[chars[i]] = -1;
                size--;
                startPoint++;
            }
            if (size == 0) {
                startPoint = -1;
            }
        }

    }


    public int lengthOfLongestSubstring2(String string) {
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




    public int lengthOfLongestSubstring3(String string) {
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
