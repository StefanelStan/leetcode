package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeFromSubstring {
    // https://leetcode.com/problems/can-make-palindrome-from-substring
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> answers = new ArrayList<>(queries.length);
        int[][] letterCount = getLetterCount(s);
        for (int[] query : queries) {
            answers.add(canMakePalindrome(letterCount, query[0], query[1], query[2]));
        }
        return answers;
    }

    private int[][] getLetterCount(String s) {
        int[][] letterCount = new int[26][s.length()];
        letterCount[s.charAt(0) - 'a'][0]++;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < 26; i++) {
                letterCount[i][j] = letterCount[i][j-1];
            }
            letterCount[s.charAt(j) - 'a'][j]++;
        }
        return letterCount;
    }

    private boolean canMakePalindrome(int[][] letterCount, int from, int end, int replacements) {
        int oddCount = 0;
        int onLeft;
        for (int i = 0; i < letterCount.length; i++) {
            onLeft = from > 0 ? letterCount[i][from - 1] : 0;
            oddCount += (letterCount[i][end] - onLeft) % 2 == 1 ? 1 : 0;
        }
        return replacements >= oddCount/2;
    }
}
