package com.ss.leetcode.september;

public class FindTheMiddleIndexInArray {
    // https://leetcode.com/contest/biweekly-contest-60/problems/find-the-middle-index-in-array/
    public int findMiddleIndex(int[] nums) {
        if (nums.length == 0 ) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] == 0 && nums[1] == 0) {
                return 0;
            }
            if (nums[0] == 0 || nums[1] == 0)
                return (nums[0] == 0 ? 1 : 0);
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum - nums[0] == 0) {
            return 0;
        }

        int partialSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            partialSum += nums[i];
            if (partialSum - nums[i] == totalSum - partialSum) {
                return i;
            }
        }
        return -1;
    }
}
