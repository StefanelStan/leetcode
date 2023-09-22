package com.ss.leetcode.LC2023.july;

public class NumberOfLongestIncreasingSubsequence {
    // https://leetcode.com/problems/number-of-longest-increasing-subsequence
    /** Algorithm
        1. Keep track of bestChain and count of chain each index can create.
        2. For each i n-2..0, for each j = i+1..n, if nums[j] > nums[i],
            - check if the chain under j is = or > chain under i
            - if equal, then increment the chain count under i with chain count under j
            - if chain under j > chain under i, then i can make a longer chain if connect with j
            so update the chainLength of i (length +1) and set chain count[i] to chainCount of j.
        3. As optimizations, also keep track of max nums[i] so far and longest existing chain.
            If there aren't numbers greater than nums[i], then just stop
            If there aren't chains longer than current chain of i, just stop.
        4. Traverse the longestChain and chainCount. and determine the sum of highest longestChains.
     */
    public int findNumberOfLIS(int[] nums) {
        int[] subseqLengthAtIndex = new int[nums.length];
        int[] subseqCountAtIndex = new int[nums.length];
        findMaxIndices(nums, subseqLengthAtIndex, subseqCountAtIndex);
        return countMax(subseqLengthAtIndex, subseqCountAtIndex);
    }

    private void findMaxIndices(int[] nums, int[] subseqLengthAtIndex, int[] subseqCountAtIndex) {
        subseqLengthAtIndex[nums.length - 1] = 1;
        subseqCountAtIndex[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    if (subseqLengthAtIndex[j] > subseqLengthAtIndex[i]) {
                        subseqLengthAtIndex[i] = subseqLengthAtIndex[j];
                        subseqCountAtIndex[i] = subseqCountAtIndex[j];
                    } else if (subseqLengthAtIndex[j] == subseqLengthAtIndex[i]) {
                        subseqCountAtIndex[i] += subseqCountAtIndex[j];
                    }
                }
            }
            subseqLengthAtIndex[i]++;
            subseqCountAtIndex[i] = Math.max(1, subseqCountAtIndex[i]);
        }
    }

    private int countMax(int[] subseqLengthAtIndex, int[] subseqCountAtIndex) {
        int maxLength = 0, maxCount = 0;
        for (int i = 0; i < subseqLengthAtIndex.length; i++) {
            if (subseqLengthAtIndex[i] > maxLength) {
                maxCount = subseqCountAtIndex[i];
                maxLength = subseqLengthAtIndex[i];
            } else if (subseqLengthAtIndex[i] == maxLength) {
                maxCount += subseqCountAtIndex[i];
            }
        }
        return maxCount;
    }


}
