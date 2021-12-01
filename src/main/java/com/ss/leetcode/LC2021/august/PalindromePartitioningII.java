package com.ss.leetcode.LC2021.august;

import java.util.Arrays;

public class PalindromePartitioningII {
    // https://leetcode.com/problems/palindrome-partitioning-ii/
    public int minCut(String s) {
        int[] bestCuts = new int[s.length() + 1];
        Arrays.fill(bestCuts, Integer.MAX_VALUE);
        bestCuts[s.length()] = 0;
        bestCuts[s.length() - 1] = 0;
        for (int i = s.length() -2; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if(j == s.length() - 1) {
                        bestCuts[i] = 0;
                        break;
                    }
                    // get prev value (j+1) and assign it to bestCuts[i] if smaller than this.
                    int x = 1 + bestCuts[j + 1];
                    if (x < bestCuts[i]) {
                        bestCuts[i] = x;
                    }
                }
            }
        }
        return bestCuts[0];
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
