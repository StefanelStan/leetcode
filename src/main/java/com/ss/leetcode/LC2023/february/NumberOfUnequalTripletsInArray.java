package com.ss.leetcode.LC2023.february;

public class NumberOfUnequalTripletsInArray {
    // https://leetcode.com/problems/number-of-unequal-triplets-in-array
    public int unequalTriplets(int[] nums) {
        int[] uniqueCount = getUniqueCount(nums);
        if(uniqueCount.length < 3) {
            return 0;
        }
        int[] backwardRollingSum = getBackwardRollingSum(uniqueCount);
        int[] crossSum = getCrossSum(uniqueCount, backwardRollingSum);
        int triples = 0;
        for (int i = 0; i < uniqueCount.length - 2; i++) {
            triples += (uniqueCount[i] * crossSum[i+1]);
        }
        return triples;
    }

    private int[] getCrossSum(int[] unique, int[] backwardRollingSum) {
        int[] crossSum = new int[unique.length];
        for (int i = unique.length - 2; i > 0; i--) {
            crossSum[i] = unique[i] * backwardRollingSum[i+1] + crossSum[i+1];
        }
        return crossSum;
    }


    private int[] getBackwardRollingSum(int[] unique) {
        int[] sum = new int[unique.length];
        sum[sum.length -1] = unique[unique.length -1];
        for (int j = sum.length -2; j >= 0; j--) {
            sum[j] = sum[j+1] + unique[j];
        }
        return sum;
    }

    private int[] getUniqueCount(int[] nums) {
        int[] count = new int[1001];
        int unique = 0;
        for (int num : nums) {
            count[num]++;
            if (count[num] == 1) {
                unique++;
            }
        }
        int[] uniqueCount = new int[unique];
        int index = 0;
        for (int j : count) {
            if (j > 0) {
                uniqueCount[index++] = j;
            }
        }
        return uniqueCount;
    }
}
