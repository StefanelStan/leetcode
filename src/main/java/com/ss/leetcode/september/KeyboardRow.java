package com.ss.leetcode.september;

import java.util.Arrays;

public class KeyboardRow {
    // https://leetcode.com/problems/keyboard-row/
    private static int[] rows = null;
    public String[] findWords(String[] words) {
        setRows();
        String[] typeableWords = new String[words.length];
        int wordsIndex = 0;
        for (String word : words) {
            if(canBeTyped(word)) {
                typeableWords[wordsIndex++] = word;
            }
        }
        return Arrays.copyOf(typeableWords, wordsIndex);
    }

    private void setRows() {
        if (rows == null) {
            rows = new int[26];
            assignRows("asdfghjkl", 1);
            assignRows("zxcvbnm", 2);
        }
    }

    private void assignRows(String s, int rowNr) {
        for (int i = 0; i < s.length(); i++) {
            rows[s.charAt(i) - 'a'] = rowNr;
        }
    }

    private boolean canBeTyped(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            int current = word.charAt(i) >= 'a' ? word.charAt(i) - 'a' : word.charAt(i) - 'A';
            int next = word.charAt(i+1) >= 'a' ? word.charAt(i+1) - 'a' : word.charAt(i+1) - 'A';
            if (rows[current] != rows[next]) {
                return false;
            }
        }
        return true;
    }
}
