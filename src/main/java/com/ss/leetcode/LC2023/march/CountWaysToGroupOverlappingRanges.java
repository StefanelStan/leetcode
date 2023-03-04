package com.ss.leetcode.LC2023.march;

import java.math.BigInteger;
import java.util.Arrays;

public class CountWaysToGroupOverlappingRanges {
    public int countWays(int[][] ranges) {
        int groups = 1;
        int endRange = 0;
        Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] candidateInterval = ranges[0];
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] <= candidateInterval[1]) {
                candidateInterval[1] = Math.max(ranges[i][1], candidateInterval[1]);
            } else {
                groups++;
                candidateInterval = ranges[i];
            }
        }
        long p = 0;
        for (int i = 1; i <= groups; i++) {
            p += calculateCombination(groups, i);
        }
        return (int) ((p % 1_000_000_007) + 1);
    }

    private long calculateCombination(int n, int k) {
        return calculateFactorial(n) / (calculateFactorial(n-k) * calculateFactorial(k));
    }

    private long calculateFactorial(int k) {
        long val = 1;
        for (int i = 1; i <= k; i++) {
            val = (val * i) % 1_000_000_007;
        }
        return val;
    }
}
