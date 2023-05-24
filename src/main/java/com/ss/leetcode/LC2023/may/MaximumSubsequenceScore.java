package com.ss.leetcode.LC2023.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    // https://leetcode.com/problems/maximum-subsequence-score
    /** Algorithm
        1. Use an int[nums1.length][2] highestNums to map each nums2 to its value/mapping on nums1
        2. Sort it by a -> a[1]: Highest coefficient at the end
        3. From j = n - k to 0, determine the max sum of k elements amongst highestNums[j == n-k .. n][0]
            to multiply it with highestNums[j][1].
        4. Use a PriorityQueue to maintain exactly k numbers from the column[0] of highest numbers.
            Each time you move j you also add another number [j][0] to the queue and eliminate the lowest.
            This way for each coefficient c in sum * c, you have access to the biggestsum you can get from
            elements [j .. n-1][0]
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] highestNums2 = getHighestNums2(nums1, nums2);
        HighestSum highestSum = getHighestSum(highestNums2, k);
        long maxScore = 0, currentScore;
        for (int i = nums1.length - k; i >= 0 && highestNums2[i][1] != 0; i--) {
            currentScore = highestSum.addNumAndGetSum(highestNums2[i][0]) *  highestNums2[i][1];
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }

    private int[][] getHighestNums2(int[] nums1, int[] nums2) {
        int[][] highestNums2 = new int[nums1.length][2];
        for(int i = 0; i < nums1.length; i++) {
            highestNums2[i][0] = nums1[i];
            highestNums2[i][1] = nums2[i];
        }
        Arrays.sort(highestNums2, Comparator.comparingInt(a -> a[1]));
        return highestNums2;
    }

    private HighestSum getHighestSum(int[][] highestNumbers, int k) {
        HighestSum highestSum = new HighestSum(k);
        for (int i = (highestNumbers.length - k) + 1; i < highestNumbers.length; i++) {
            highestSum.addNumAndGetSum(highestNumbers[i][0]);
        }
        return highestSum;
    }

    private static class HighestSum {
        int maxSize;
        long sum;
        PriorityQueue<Integer> nums;
        public HighestSum(int size) {
            maxSize = size;
            nums = new PriorityQueue<>();
        }

        public long addNumAndGetSum(int num) {
            nums.add(num);
            sum += num;
            if (nums.size() > maxSize) {
                sum -= nums.poll();
            }
            return sum;
        }
    }
}
