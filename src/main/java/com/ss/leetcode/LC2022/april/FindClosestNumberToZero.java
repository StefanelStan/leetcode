package com.ss.leetcode.LC2022.april;

public class FindClosestNumberToZero {
    // https://leetcode.com/contest/biweekly-contest-76/problems/find-closest-number-to-zero/
    public int findClosestNumber(int[] nums) {
        int[] closest = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int num : nums) {
            if (Math.abs(num) == closest[0]) {
                closest[1] = Math.max(closest[1], num);
            } else if (Math.abs(num) < closest[0]) {
                closest[0] = Math.abs(num);
                closest[1] = num;
            }
        }
        return closest[1];
    }
}
