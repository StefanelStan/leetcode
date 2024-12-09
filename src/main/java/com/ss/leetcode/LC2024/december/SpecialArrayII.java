package com.ss.leetcode.LC2024.december;

public class SpecialArrayII {
    // https://leetcode.com/problems/special-array-ii
    /** Algorithm
        1. Compare a prefix count of parities for each pair [i, i+1]. If a pair is good, the prefix increses by 0, else by 1.
        2. If the interval [a,b] is good, then the prefixParity of [a] == prefixParity[b].
            - else there will be a difference.
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] parityScores = getParityScores(nums);
        boolean[] isSpecial = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            isSpecial[i] = answerQuery(queries[i][0], queries[i][1], parityScores);
        }
        return isSpecial;
    }

    private boolean answerQuery(int left, int right, int[] parityScores) {
        if (left == right) {
            return true;
        } else {
            int leftScore = left == 0 ? 0 : parityScores[left - 1];
            return leftScore == parityScores[right - 1];
        }
    }

    private int[] getParityScores(int[] nums) {
        int[] parityScores = new int[nums.length - 1];
        int prev = 0;
        for (int i = 0; i < parityScores.length; i++) {
            parityScores[i] = prev + (nums[i] % 2 == nums[i+1] % 2 ? 1 : 0);
            prev = parityScores[i];
        }
        return parityScores;
    }
}
