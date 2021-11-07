package com.ss.leetcode.november;

import java.util.Arrays;

public class SingleNumberIII {
    // https://leetcode.com/problems/single-number-iii/
    public int[] singleNumber(int[] nums) {
        int[] singles = new int[2];
        int index = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1;) {
            if (nums[i] == nums[i+1]) {
                i+=2;
            } else {
                singles[index++] = nums[i];
                i++;
            }
        }
        if (index == 1) {
            singles[1] = nums[nums.length -1];
        }
        return singles;
    }
}
