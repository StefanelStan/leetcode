package com.ss.leetcode.LC2024.march;

public class MaximumLengthSubstringWithTwoOccurrences {
    // https://leetcode.com/problems/maximum-length-substring-with-two-occurrences
    /** Algorithm
        1. SlidingWindow: offer chars while the count of each char is <=2  Retain max size.
        2. Reduce the window until that bad count goes back to 2.
            A bad count has a count of 3, so it needs to go back to 2 for that particular letter.
        3. Return max size
     */
    public int maximumLengthSubstring(String s) {
        int maxSize = 0;
        int left = 0;
        SubstringWindow sw = new SubstringWindow();
        for (int right = 0; right < s.length(); right++) {
            sw.offer(s.charAt(right));

            while (!sw.isValid) {
                sw.remove(s.charAt(left++));
            }
            maxSize = Math.max(maxSize, 1 + right - left);
        }
        return maxSize;
    }

    private static class SubstringWindow {
        int[] count = new int[26];
        boolean isValid = true;

        public void offer(char ch) {
            isValid = ++count[ch - 'a'] < 3;
        }

        public void remove(char ch) {
            if (--count[ch - 'a'] == 2) {
                isValid = true;
            }
        }
    }
}
