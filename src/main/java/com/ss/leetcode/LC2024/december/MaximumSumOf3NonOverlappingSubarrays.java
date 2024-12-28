package com.ss.leetcode.LC2024.december;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumOf3NonOverlappingSubarrays {
    // https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] sumAndMaxOnRight = getSumAndMaxOnRight(nums, k);
        MaxValueAndIndex[] bestTwo = getBestNonOverlapping(sumAndMaxOnRight, k);
        MaxValueAndIndex[] bestThree = getBestNonOverlapping(sumAndMaxOnRight, bestTwo, k);
        return new int[]{bestThree[0].indices.get(0), bestThree[0].indices.get(1), bestThree[0].indices.get(2)};
    }

    private MaxValueAndIndex[] getBestNonOverlapping(int[][] sumAndMaxOnRight, MaxValueAndIndex[] bestTwo, int k) {
        MaxValueAndIndex[] bestThree = new MaxValueAndIndex[sumAndMaxOnRight.length];
        for (int i = 0; i < bestThree.length; i++) {
            bestThree[i] = new MaxValueAndIndex();
        }
        int candidateSum;
        for (int i = sumAndMaxOnRight.length - 3 * k; i >= 0; i--) {
            candidateSum = sumAndMaxOnRight[i][0] + bestTwo[i + k].value;
            if (candidateSum >= bestThree[i+1].value) {
                bestThree[i].value = candidateSum;
                bestThree[i].indices.add(i);
                bestThree[i].indices.addAll(bestTwo[i + k].indices);
            } else {
                bestThree[i].value = bestThree[i+1].value;
                bestThree[i].indices = bestThree[i+1].indices;
            }
        }
        return bestThree;
    }

    private MaxValueAndIndex[] getBestNonOverlapping(int[][] sumAndMaxOnRight, int k) {
        MaxValueAndIndex[] bestTwo = new MaxValueAndIndex[sumAndMaxOnRight.length];
        for (int i = 0; i < bestTwo.length; i++) {
            bestTwo[i] = new MaxValueAndIndex();
        }
        int candidateSum;
        for (int i = sumAndMaxOnRight.length - 2 * k; i >= 0; i--) {
            candidateSum = sumAndMaxOnRight[i][0] + sumAndMaxOnRight[i + k][1];
            if (candidateSum >= bestTwo[i+1].value) {
                bestTwo[i].value = candidateSum;
                bestTwo[i].indices.add(i);
                bestTwo[i].indices.add(sumAndMaxOnRight[i + k][2]);
            } else {
                bestTwo[i].value = bestTwo[i+1].value;
                bestTwo[i].indices = bestTwo[i+1].indices;
            }
        }
        return bestTwo;
    }

    private int[][] getSumAndMaxOnRight(int[] nums, int k) {
        int[][] sumAndMaxOnRight = new int[nums.length][3];
        int sum = 0, index = -1;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            sum += nums[i];
        }
        sumAndMaxOnRight[nums.length - k][0] = sum;
        sumAndMaxOnRight[nums.length - k][1] = sum;
        sumAndMaxOnRight[nums.length - k][2] = nums.length - k;
        for (int i = nums.length - (k + 1), j = nums.length - 1; i>= 0; i--, j--) {
            sum += nums[i] - nums[j];
            sumAndMaxOnRight[i][0] = sum;
            if (sumAndMaxOnRight[i+1][1] > sum) {
                sumAndMaxOnRight[i][1] = sumAndMaxOnRight[i + 1][1];
                sumAndMaxOnRight[i][2] = sumAndMaxOnRight[i + 1][2];
            } else {
                sumAndMaxOnRight[i][1] = sum;
                sumAndMaxOnRight[i][2] = i;
            }
        }
        return sumAndMaxOnRight;
    }

    private static class MaxValueAndIndex {
        int value;
        List<Integer> indices;
        public MaxValueAndIndex() {
            this.indices = new ArrayList<>();
        }
    }
}
