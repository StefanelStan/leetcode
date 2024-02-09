package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    // https://leetcode.com/problems/largest-divisible-subset/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] divisibleSubsets = new int[nums.length][2];
        // [size, nextIndex]
        int maxLength = 1, maxLengthIndex = 0, currentMaxLength, currentMaxLengthIndex;
        for (int i = 0; i < nums.length; i++) {
            currentMaxLength = currentMaxLengthIndex = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (divisibleSubsets[j][0] > currentMaxLength) {
                        currentMaxLength = divisibleSubsets[j][0];
                        currentMaxLengthIndex = j;
                    }
                }
            }
            if (currentMaxLength > 0) {
                divisibleSubsets[i][0] = 1 + currentMaxLength;
                divisibleSubsets[i][1] = currentMaxLengthIndex;
            } else {
                divisibleSubsets[i][0] = 1;
                divisibleSubsets[i][1] = -1;
            }
            if (divisibleSubsets[i][0] > maxLength) {
                maxLength = divisibleSubsets[i][0];
                maxLengthIndex = i;
            }
        }
        return fetchLongestsSubset(maxLengthIndex, divisibleSubsets, nums);
    }

    private List<Integer> fetchLongestsSubset(int from, int[][] divisibleSubsets, int[] nums) {
        List<Integer> subset = new ArrayList<>(divisibleSubsets[from][0]);
        while (from != -1) {
            subset.add(nums[from]);
            from = divisibleSubsets[from][1];
        }
        return subset;
    }


    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> longestSubset = new ArrayList<>();
        if (nums.length == 1) {
            longestSubset.add(nums[0]);
        } else {
            longestSubset = findLongestDivisibleSubset(nums);
        }
        return longestSubset;
    }

    private List<Integer> findLongestDivisibleSubset(int[] nums) {
        List<Integer> longestSubset = new ArrayList<>();
        Arrays.sort(nums);
        // row [0] will keep max chain and row[1] will keep nextPosition of longest chain
        int[][] divChains = new int[2][nums.length];
        divChains[0][0] = 1;
        divChains[1][0] = -1;
        int maxChainPosition = getMaxChainPosition(divChains, nums);
        boolean finishedAdding = false;
        while (maxChainPosition != -1) {
            longestSubset.add(nums[maxChainPosition]);
            maxChainPosition = divChains[1][maxChainPosition];
        }
        return longestSubset;
    }

    private int getMaxChainPosition(int[][] divChains, int[] nums) {
        int maxChain, totalMaxChain = 0, totalMaxStart = 0, tempStop;
        for (int i = 1; i < nums.length; i++) {
            maxChain = 0;
            tempStop = 0;
            int nextDivisible = -1;
            for (int j = i - 1; j >= tempStop; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (tempStop == 0) {
                        tempStop = Math.max(0, divChains[1][j]);
                    }
                    if (divChains[0][j] > maxChain) {
                        maxChain = divChains[0][j];
                        nextDivisible = j;
                    }
                }
            }
            divChains[0][i] = ++maxChain;
            divChains[1][i] = nextDivisible;
            if (maxChain > totalMaxChain) {
                totalMaxStart = i;
                totalMaxChain = maxChain;
            }
        }
        return totalMaxStart;
    }
}
