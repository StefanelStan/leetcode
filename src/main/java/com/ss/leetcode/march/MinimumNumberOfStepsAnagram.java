package com.ss.leetcode.march;

public class MinimumNumberOfStepsAnagram {
    // https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
    public int minSteps(String s, String t) {
        int[] letters = new int[26];
        int position1, position2;
        for (int i = 0; i < s.length(); i++) {
            position1 = s.charAt(i) - 97;
            position2 = t.charAt(i) - 97;
            letters[position1]++;
            letters[position2]--;
        }
        int diff = 0;
        for (int count: letters) {
            diff += Math.abs(count);
        }
        return diff / 2;
    }
}
