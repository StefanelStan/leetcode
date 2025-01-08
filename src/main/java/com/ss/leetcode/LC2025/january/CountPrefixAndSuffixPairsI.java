package com.ss.leetcode.LC2025.january;

public class CountPrefixAndSuffixPairsI {
    // https://leetcode.com/problems/count-prefix-and-suffix-pairs-i
    /** Algorithm
        1. Loop with j from n - 1 to 1 and inside with i from 0 to j
        2. If words[i].length < words[j] && isPrefixAndSuffix, increment count by 1.
     */
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int j = words.length -1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                count += (words[i].length() <= words[j].length() && isPrefixAndSuffix(words[i], words[j]) ? 1 : 0);
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String left, String right) {
        return right.startsWith(left) && right.endsWith(left);
    }
}
