package com.ss.leetcode.LC2023.august;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    // https://leetcode.com/problems/maximum-length-of-pair-chain
    public int findLongestChain(int[][] pairs) {
        if (pairs.length ==1) {
            return 1;
        }
        int[] longestPairs = determineLongestPairs(pairs);
        return longestPairs[0];
    }

    private int[] determineLongestPairs(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[0] == b[0] ? Integer.compare(b[1],a[1]) : Integer.compare(a[0], b[0]));
        int[] longestPairs = new int[pairs.length];
        longestPairs[pairs.length -1] = 1;
        int candidate = 0;
        for (int i = pairs.length - 2; i >= 0; i--) {
            if (pairs[i][0] == pairs[i+1][0]) {
                longestPairs[i] = longestPairs[i+1];
            } else {
                candidate = 1 + findLongestChain(pairs, longestPairs, i + 1, pairs[i][1] + 1);
                longestPairs[i] = Math.max(candidate, longestPairs[i+1]);
            }
        }
        return longestPairs;
    }

    private int findLongestChain(int[][] pairs, int[] longestPairs, int low, int target) {
        int high = pairs.length -1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (pairs[pivot][0] == target) {
                return longestPairs[pivot];
            } else if (pairs[pivot][0] < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low == pairs.length ? 0 : longestPairs[low];
    }
}
