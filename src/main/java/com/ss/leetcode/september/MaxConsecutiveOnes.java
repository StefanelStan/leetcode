package com.ss.leetcode.september;

public class MaxConsecutiveOnes {
    // https://leetcode.com/problems/max-consecutive-ones/
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int tempConsecutive = 0;
        for(int num : nums) {
            if (num == 1) {
                tempConsecutive++;
                maxConsecutive = Math.max(maxConsecutive, tempConsecutive);
            } else {
                tempConsecutive = 0;
            }
        }
        return maxConsecutive;
    }
}
