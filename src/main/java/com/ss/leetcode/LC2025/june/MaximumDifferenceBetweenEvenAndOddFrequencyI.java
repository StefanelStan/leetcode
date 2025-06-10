package com.ss.leetcode.LC2025.june;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    // https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i
    /** Algorithm
        1. Store the frequency of each char on the string in a int[26] count;
        2. Traverse the count[] array and get the max odd frequency and min even freq
        3. Return their diff.
     */
    public int maxDifference(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int maxOddFreq = Integer.MIN_VALUE, minEvenFreq = Integer.MAX_VALUE;
        for (int c : count) {
            if (c > 0) {
                if (c % 2 == 1) {
                    maxOddFreq = Math.max(maxOddFreq, c);
                } else {
                    minEvenFreq = Math.min(minEvenFreq, c);
                }
            }
        }
        return maxOddFreq - minEvenFreq;
    }
}
