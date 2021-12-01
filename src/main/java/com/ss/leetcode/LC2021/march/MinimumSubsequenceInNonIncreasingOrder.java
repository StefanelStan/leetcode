package com.ss.leetcode.LC2021.march;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {
    // https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        int sum = 0;
        int listSum = 0;
        for (int value : nums) {
            sum += value;
        }
        sum = sum /2;
        for (int i = nums.length -1; i >= 0; i--) {
            list.add(nums[i]);
            listSum += nums[i];
            if (listSum > sum) {
                break;
            }
        }
        return list;
    }
}
