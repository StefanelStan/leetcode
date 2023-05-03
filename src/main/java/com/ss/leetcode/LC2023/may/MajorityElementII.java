package com.ss.leetcode.LC2023.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    // https://leetcode.com/problems/majority-element-ii
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> majorElements = new ArrayList<>();
        int majority = nums.length / 3;
        int prev = Integer.MAX_VALUE, count = 0;
        for (int num : nums) {
            if (num == prev) {
                count++;
            } else {
                if (count > majority) {
                    majorElements.add(prev);
                }
                count = 1;
            }
            prev = num;
        }
        if (count > majority) {
            majorElements.add(prev);
        }
        return majorElements;
    }
}
