package com.ss.leetcode.LC2022.june;

import java.util.Arrays;

public class MaximumErasureValue {
    // https://leetcode.com/problems/maximum-erasure-value/
    /** Algorithm
         1. Apply a Flexible Window/Sliding window algorithm to keep track of your unique numbers window.
         2. Use an array[] positions to store the last positions of your elements in the Flexible Window.
         3. Iterate over the array and
            a. If the position of current number is -1, (does not exist in window), add it and expand the window or its sum/max sum. Also, keep track of your window starting point.
            b. If the position is != -1, it means the elements exists in the window, and you have to trim the left
            side of the window until you get rid of that element.
            EG: 2,1,3,5,3,9.
            when i = 5, your window has starting position of 0, sum of 11. As positions[3] == 2, you have this element already, so loop from the startPoint until position 2, deduct the elements from your array/reset their positions and set the new startingPoint to 3 (the next position where the duplicate element does not exist)
         c. At this stage your flexible window from [2,1,3,5] will be changed to [5,3].
         4. Keep track of maxSum and return it.
     */
    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        UniqueWindow uw = new UniqueWindow(nums);
        uw.processNums();
        return uw.maxSum;
    }

    private static class UniqueWindow {
        int startPos;
        int maxSum;
        int sum;
        int[] nums;
        int[] positions;

        public UniqueWindow(int[] nums) {
            this.positions = new int[10001];
            this.nums = nums;
            Arrays.fill(positions, -1);
        }

        void processNums() {
            for (int i = 0; i < nums.length; i++) {
                if (positions[nums[i]] != -1) {
                    trimToPosition(positions[nums[i]]);
                }
                positions[nums[i]] = i;
                sum += nums[i];
                maxSum = Math.max(maxSum, sum);
            }
        }

        private void trimToPosition(int end) {
            for (int i = startPos; i <= end; i++) {
                sum -= nums[i];
                positions[nums[i]] = -1;
            }
            startPos = end + 1;
        }
    }
}
