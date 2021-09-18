package com.ss.leetcode.september;

public class CountPairsAbsoluteDifferenceK {
    // https://leetcode.com/contest/biweekly-contest-61/problems/count-number-of-pairs-with-absolute-difference-k/
    public int countKDifference(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int pairs = 0;
        for (int i = 1; i < count.length -1; i++) {
            for (int j = i+1; j < count.length; j++) {
                if (count[i] > 0 && count[j] > 0 && Math.abs(i - j) == k) {
                    pairs += count[i] * count[j];
                }
            }
        }
        return pairs;
    }
}
