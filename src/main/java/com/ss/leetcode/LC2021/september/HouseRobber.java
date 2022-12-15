package com.ss.leetcode.LC2021.september;

public class HouseRobber {
    // https://leetcode.com/problems/house-robber/

    /** Algorithm
     *  1. You need to keep track of how much money you can make for each house (i)
     *  2. For each i, if you rob this house (nums[i]) you can add the total[i-2]
     *  3. Or you can skip this house and keep the total[i-1]
     *  4. Depending on max of #2 and #3
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] totalCash = new int[nums.length];
        totalCash[0] = nums[0];
        totalCash[1] = Math.max(totalCash[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            totalCash[i] = Math.max(totalCash[i - 2] + nums[i], totalCash[i - 1]);
        }
        return totalCash[nums.length - 1];
    }
}
