package com.ss.leetcode.LC2023.march;

public class MinimumNumberOfStepsToMakeTwoStringsAnagramII {
    // https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii
    /** Algorithm
        1. For two words to be anagrams, they need to have the same amount of letters of each kind
        2. Count the letters of both words and store them in two int[26] (a-z)
        3. Traverse the count arrays and sum of their differences (Math.abs) for each letter.
        4. Return the sum;
     */
    public int minSteps(String s, String t) {
        int[] sCount = count(s);
        int[] tCount = count(t);
        int minSteps = 0;
        for(int i = 0; i < sCount.length; i++) {
            minSteps += Math.abs(sCount[i] - tCount[i]);
        }
        return minSteps;
    }

    private int[] count(String str) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
}
