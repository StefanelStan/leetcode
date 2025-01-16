package com.ss.leetcode.LC2025.january;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    // https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i
    /** Algorithm
        1. If k == 1 return true
        2. Loop with i from 0 to n - 2 * k and for each index check if the subarray [i..i+k - 1] and [i +k .. i + 2*k] are increasing
        3. Checking if 2 arrays are increasing:
             - loop with 2 indices j and k (j = i, p = i + k) for k - 1 steps
            - if (nums[j+1] <= nums[j] OR nums[p+1] <= nums[p]) return false
            - else return true.
        4. Return true for 1st true, else false.
     */
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k == 1) {
            return true;
        }
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            if (areAdjacentIncreasing(nums, i, i + k)) {
                return true;
            }
        }
        return false;
    }

    private boolean areAdjacentIncreasing(List<Integer> nums, int start1, int start2) {
        for (int i = 1; start1 + i < start2; i++) {
            if (nums.get(start1 + i) <= nums.get(start1 + i - 1) || nums.get(start2 + i) <= nums.get(start2 + i - 1)) {
                return false;
            }
        }
        return true;
    }
}
