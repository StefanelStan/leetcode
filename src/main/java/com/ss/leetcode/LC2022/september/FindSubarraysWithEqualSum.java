package com.ss.leetcode.LC2022.september;

import java.util.HashSet;
import java.util.Set;

public class FindSubarraysWithEqualSum {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < nums.length -1; i++) {
            if (!sums.add(nums[i] + nums[i+1])) {
                return true;
            }
        }
        return false;
    }
}
