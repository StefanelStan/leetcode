package com.ss.leetcode.LC2023.june;

public class LongestIdealSubsequence {
    // https://leetcode.com/problems/longest-ideal-subsequence
    /** Algorithm EG: "acfgbd", k = 2
        1. Start from the back, (letter d) and see what is the max chain d can make.
            As it's the last letter, it can make a chain of 1 (itself)
        2. Use an int[26] (a-z) to mark the chain length that current letter can make with the letters to the LEFT on its position.
            b has letter d to its left. As b + 2 <= d, d is a valid chain so int[b] = int[d] + 1 (2)
        3. When deciding what letters are BEST to make a chain FOR the current letter,
            do not travel to the LEFT of the string, as string can have 10^5 elements,
            Instead travel to the left/right of current letter inside the int[].
            EG: travel k elements to the left and right of b : 2 elements at the left of b inside [] are -1 and a.
            Two elements at the right of b inside int[] are c and d. The max between these 5 is 1 so int[b] = int[d] + 1.
        4. g -> travel 2 letters to the left of g (e,f) and 2 letters at the right of g (h,i). Determine their max and set int[g] = max + 1.
        5. When doing this for all letters inside the string, traverse the int[] and return the max value recorded.
     */
    public int longestIdealString(String s, int k) {
        int[] longestSubsequences = new int[26];
        for (int i = s.length() -1; i>= 0; i--) {
            setLongestSubsequence(longestSubsequences, s.charAt(i) - 'a', k);
        }
        int longest = 0;
        for (int length : longestSubsequences) {
            longest = Math.max(longest, length);
        }
        return longest;
    }

    private void setLongestSubsequence(int[] subsequences, int from, int k) {
        int max = 0, i = 0;
        boolean set = true;
        while (set && i <= k) {
            set = false;
            if (from - i >= 0) {
                max = Math.max(max, subsequences[from - i]);
                set = true;
            }
            if (from + i < 26) {
                max = Math.max(max, subsequences[from + i]);
                set = true;
            }
            i++;
        }
        subsequences[from] = max + 1;
    }
}
