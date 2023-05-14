package com.ss.leetcode.LC2023.may;

import java.util.Arrays;

public class MaximizeScoreAfterNOperations {
    // https://leetcode.com/problems/maximize-score-after-n-operations/
    // TODO FIX
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int[][] gcd = calculateGcd(nums);
        return calculateMaxScore(nums, gcd);
    }

    private int calculateMaxScore(int[] nums, int[][] gcd) {
        boolean[] used = new boolean[nums.length];
        int maxScore = 0;
        int iteration = nums.length /2;
        while (iteration > 0) {
            int[] best = getBestGcd(nums, used, gcd, iteration);
//            System.out.println(nums[best[0]] + "&" + nums[best[1]] + "=" + gcd[best[0]][best[1]]);
            used[best[0]] = true;
            used[best[1]] = true;
            maxScore += iteration * gcd[best[0]][best[1]];
            iteration--;
        }
        return maxScore;
    }

    private int[] getBestGcd(int[] nums, boolean[] used, int[][] gcd, int iteration) {
        int[] maxPositions = new int[2];
        int maxIndicesToSearch = iteration * 2 - 1;
        int bestGcd = 0;
        int i = nums.length -1;
        while (maxIndicesToSearch > 0) {
            while (used[i]) {
                i--;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (!used[j]) {
                    if (gcd[i][j] > bestGcd) {
                        bestGcd = gcd[i][j];
                        maxPositions[0] = i;
                        maxPositions[1] = j;
                    }
                }
            }
            i--;
            maxIndicesToSearch--;
        }
        return maxPositions;
    }

    private int[][] calculateGcd(int[] nums) {
        int[][] gcd = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i +1; j < nums.length; j++) {
                gcd[j][i] = gcd[i][j] = getGcd(nums[i], nums[j]);
            }
        }
        return gcd;
    }

    private int getGcd(int min, int max) {
        if (max % min == 0) {
            return min;
        }
        boolean bothEven = max % 2 == 0 && min % 2 == 0;
        int from = min / 2;
        if ((bothEven && from % 2 == 1) || (!bothEven && from % 2 == 0)) {
            from++;
        }

        while (from > 0) {
            if (max % from == 0 && min % from == 0) {
                return from;
            }
            from -= 2;
        }
        return 1;
    }
}
