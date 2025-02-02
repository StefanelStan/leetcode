package com.ss.leetcode.LC2023.march;

public class CheckIfArrayIsSortedAndRotated {
    // https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
    /** Algorithm
        1. Traverse array and if nums[i] > nums[i+1] then you have a decreasing spot.
        2. An increasing array or rotated cannot have more than 1 decreasing spot.
        3. If you have >= 2 spots, return false. If you have 0 spots, return true.
        4. Else, if you have 1 spot, then the nums[0] must be >= than nums[spot] and >= nums[n-1].
     */
    public boolean check(int[] nums) {
        int decreasingTimes = 0, decreasingIndex = -1;
        for (int i = 0; i < nums.length - 1 && decreasingTimes < 2; i++) {
            if (nums[i] > nums[i+1]) {
                decreasingTimes++;
                decreasingIndex = i + 1;
            }
        }
        return decreasingTimes > 1 ? false : decreasingTimes == 0 ? true : nums[0] >= nums[decreasingIndex] && nums[0] >= nums[nums.length - 1];
    }

    public boolean check2(int[] nums) {
        boolean rotationEncountered = false;
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i+1]) {
                if (rotationEncountered && nums[i+1] > min) {
                    return false;
                }
            } else {
                if(rotationEncountered || nums[i+1] > min) {
                    return false;
                }
                rotationEncountered = true;
            }
        }
        return true;
    }
}
