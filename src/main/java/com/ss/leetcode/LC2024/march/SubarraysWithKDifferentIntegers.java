package com.ss.leetcode.LC2024.march;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    // https://leetcode.com/problems/subarrays-with-k-different-integers
    // TODO
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarraysWithDistinctSize(nums, k) - countSubarraysWithDistinctSize(nums, k - 1);
    }

    private int countSubarraysWithDistinctSize(int[] nums, int k) {
        int count = 0, left = 0;
        Map<Integer, Integer> window = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            window.merge(nums[right], 1, Integer::sum);
            while (window.size() > k) {
                remove(nums[left++], window);
            }
            count += 1 + right - left;
        }
        return count;
    }

    private void remove(int num, Map<Integer, Integer> window) {
        if (window.merge(num, -1, Integer::sum) == 0) {
            window.remove(num);
        }
    }
}
