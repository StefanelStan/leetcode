package com.ss.leetcode.LC2023.june;

public class RemovingMinimumAndMaximumFromArray {
    // https://leetcode.com/problems/removing-minimum-and-maximum-from-array
    /** Algorithm
     1. If nums.length < 3, return its size immediately.
     2. Traverse nums and get the index of min and max.
     3. For a better understanding, determine which of these is on left and which is on the right.
     (eg: minIndex = 7, maxIndex = 3 => left = 3 and right = 7.
     4. You have 3 options to remove items:
     - from the beginning all the way to rightIndex (so rightIndex + 1)
     - from the end all the way to the LeftIndex (so nums.length - leftIndex)
     - from beginning to leftIndex + end all to way to rightIndex
     5. Return the min of the 3 options from #4.
     */
    public int minimumDeletions(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int minSoFar = Integer.MAX_VALUE, minIndex = 0;
        int maxSoFar = Integer.MIN_VALUE, maxIndex = 0;
        for (int i= 0; i < nums.length; i++) {
            if (nums[i] > maxSoFar) {
                maxSoFar = nums[i];
                maxIndex = i;
            }
            if (nums[i] < minSoFar) {
                minSoFar = nums[i];
                minIndex = i;
            }
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);
        return Math.min(left + 1 + nums.length - right, Math.min(right + 1,  nums.length - left));
    }
}
