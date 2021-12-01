package com.ss.leetcode.LC2021.september;

public class MaximumNumberOfBalloons {
    // https://leetcode.com/problems/maximum-number-of-balloons/
    public int maxNumberOfBalloons(String text) {
        int minBalloons = Integer.MAX_VALUE;
        int[] balloonChars = getCharCount("balloon");
        int[] textChars = getCharCount(text);
        for (int i = 0; i < balloonChars.length; i++) {
            if (balloonChars[i] > 0) {
                minBalloons = Math.min(textChars[i] / balloonChars[i], minBalloons);
            }
        }
        return minBalloons;
    }

    private int[] getCharCount(String text) {
        int[] textChars = new int[26];
        for (int i = 0; i < text.length(); i++) {
            textChars[text.charAt(i) - 'a']++;
        }
        return textChars;
    }
}
