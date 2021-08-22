package com.ss.leetcode.august;

public class MinTimeTypeWordSpecialTypewriter {
    public int minTimeToType(String word) {
        char currentChar = 'a';
        int totalTime = 0;
        for (char c: word.toCharArray()) {
            if (c == currentChar) {
                totalTime++;
            } else {
                int min1 = Math.abs(currentChar - c);
                int min2 = Math.abs('z' - currentChar) + Math.abs(c - 'a') + 1;
                int min3 = Math.abs(currentChar - 'a') + Math.abs('z' - c) + 1;
                totalTime += Math.min(Math.min(min1, min2), min3);
                totalTime++;
            }
            currentChar = c;
        }
        return totalTime;
    }
}
