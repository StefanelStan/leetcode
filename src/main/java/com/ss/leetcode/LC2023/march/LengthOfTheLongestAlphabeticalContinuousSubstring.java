package com.ss.leetcode.LC2023.march;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    /** Algorithm
        1. Traverse with index from i to length -2 (inclusive) and check if currentChar +1 == nextChar.
            Use the ints longest to keep track of max Length and currentLength to keep track of current sequence.
        2. If they are equal, increase the currentLength and set the longest to be max between longest and currentLength
        3. If not, reset the currentLength to 1.
        4. Return longest;
     */
    public int longestContinuousSubstring(String s) {
        int longest = 1;
        int currentLongest = 1;
        char prev = s.charAt(0), current;
        for(int i = 1; i < s.length() && longest < 26; i++) {
            current = s.charAt(i);
            if (prev + 1 == current) {
                currentLongest++;
                longest = Math.max(longest, currentLongest);
            } else {
                currentLongest = 1;
            }
            prev = current;
        }
        return longest;
    }
}
