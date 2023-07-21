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
        3. As optimizations, also keep track of max nums[i] so far and longext existing chain.
            If there aren't numbers greater than nums[i], then just stop
            If there aren't chains longer than current chain of i, just stop.
        4. Traverse the longestChain and chainCount. and determine the sum of highest longestChains.
     */
    public int findNumberOfLIS(int[] nums) {
        int[] bestChainAtIndex = new int[nums.length];
        int[] countChains = new int[nums.length];
        int[] maxChainFound = new int[nums.length];
        int[] maxSoFar = new int[nums.length];
        findBestChains(nums, bestChainAtIndex, countChains, maxChainFound, maxSoFar);
        return countBestChains(bestChainAtIndex, countChains);
    }

    private int countBestChains(int[] bestChainAtIndex, int[] countChains) {
        int longestChain = 0, longestChainCount = 0;
        for (int i = 0; i < bestChainAtIndex.length; i++) {
            if (bestChainAtIndex[i] == longestChain) {
                longestChainCount += countChains[i];
            } else if (bestChainAtIndex[i] > longestChain) {
                longestChain = bestChainAtIndex[i];
                longestChainCount = countChains[i];
            }
        }
        return longestChainCount;
    }

    private void findBestChains(int[] nums, int[] bestChainAtIndex, int[] chainCount, int[] maxChainFound, int[] maxSoFar) {
        bestChainAtIndex[nums.length - 1] = 1;
        chainCount[nums.length -1] = 1;
        maxChainFound[nums.length - 1] = 1;
        maxSoFar[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i>= 0; i--) {
            bestChainAtIndex[i] = 1;
            chainCount[i] = 1;
            for (int j = i + 1; j < nums.length && nums[i] <= maxSoFar[j] && maxChainFound[j] >= maxChainFound[i]; j++) {
                if (nums[j] > nums[i]) {
                    if (bestChainAtIndex[j] + 1 == bestChainAtIndex[i]) {
                        chainCount[i] += chainCount[j];
                    } else if (bestChainAtIndex[j] + 1 > bestChainAtIndex[i]) {
                        bestChainAtIndex[i] = bestChainAtIndex[j] + 1;
                        chainCount[i] = chainCount[j];
                    }
                }
            }
            maxSoFar[i] = Math.max(maxSoFar[i+1], nums[i]);
            maxChainFound[i] = Math.max(maxChainFound[i+1], bestChainAtIndex[i]);
        }
    }
}
