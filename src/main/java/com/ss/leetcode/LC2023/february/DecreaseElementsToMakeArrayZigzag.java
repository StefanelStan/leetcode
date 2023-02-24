package com.ss.leetcode.LC2023.february;

public class DecreaseElementsToMakeArrayZigzag {
    // https://leetcode.com/problems/decrease-elements-to-make-array-zigzag
    /** Algorithm
        1. Edge cases: length is 1 - return 0, length is 2, return 1 if they are equal, 0 otherwise
        2. Traverse the array and check the two conditions.
            - if index is even, check how much you need to reduce nums[i] to be less than left or right (cond2)
            - if index is off, check how much you ned to reduce nums[i] to be less than left/right. (cond1)
        3. For each step #2, keep track of minCond1, minCond2 and return their min.
     */
    public int movesToMakeZigzag(int[] nums) {
        int moves = 0;
        if (nums.length > 2) {
            moves = getMinNumberOfMoves(nums);
        } else if (nums.length == 2) {
            moves = nums[0] != nums[1] ? 0 : 1;
        }
        return moves;
    }

    private int getMinNumberOfMoves(int[] nums) {
        int minCondTwo = 0, minCondOne = 0;
        int onLeft, onRight;
        for (int i = 0; i < nums.length; i++) {
            // condition 2
            if (i % 2 == 0) {
                onLeft = i == 0 ? 0 : nums[i-1] <= nums[i] ? nums[i] +1 - nums[i-1] : 0;
                onRight = i == nums.length -1 ? 0 : nums[i] >= nums[i+1] ? nums[i] +1 - nums[i+1] : 0;
                minCondTwo += Math.max(onLeft, onRight);
            } else { // condition 1
                onLeft = nums[i-1] > nums[i] ? 0 : nums[i] + 1 - nums[i-1];
                onRight = i == nums.length -1 ? 0 : nums[i+1] > nums[i] ? 0 : nums[i] + 1 - nums[i+1];
                minCondOne += Math.max(onLeft, onRight);
            }
        }
        return Math.min(minCondOne, minCondTwo);
    }
}
