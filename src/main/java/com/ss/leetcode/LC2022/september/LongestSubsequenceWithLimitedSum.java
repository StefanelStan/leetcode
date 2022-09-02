package com.ss.leetcode.LC2022.september;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    // https://leetcode.com/problems/longest-subsequence-with-limited-sum/
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] cumulativeSum = getCumulativeSortedSum(nums);
        return resolveQueries(cumulativeSum, queries);
    }

    private int[] getCumulativeSortedSum(int[] nums) {
        Arrays.sort(nums);
        int[] cumulativeSum = new int[nums.length + 1];
        for (int numIndex = 0, csIndex = 1; numIndex < nums.length; numIndex++, csIndex++) {
            cumulativeSum[csIndex] = cumulativeSum[csIndex - 1] + nums[numIndex];
        }
        return cumulativeSum;
    }

    private int[] resolveQueries(int[] cumulativeSum, int[] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = getLongestSegment(cumulativeSum, queries[i]);
        }
        return answer;
    }

    private int getLongestSegment(int[] cumulativeSum, int query) {
        int low = 1, high = cumulativeSum.length -1;
        int pivot;
        while (low < high) {
            pivot = low + (high - low) / 2;
            if (cumulativeSum[low] > query){
                return low - 1;
            } else if (cumulativeSum[high] <= query) {
                return high;
            } else if (high - low == 1) {
                return cumulativeSum[high] <= query ? high : low;
            } else if (cumulativeSum[low] == query) {
                return low;
            } else if (cumulativeSum[pivot] == query) {
                return pivot;
            } else if (cumulativeSum[pivot] > query) {
                high = pivot;
            } else {
                low = pivot;
            }
        }
        return low;
    }
}
