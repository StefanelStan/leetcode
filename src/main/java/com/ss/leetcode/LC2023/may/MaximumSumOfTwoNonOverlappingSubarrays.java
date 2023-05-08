package com.ss.leetcode.LC2023.may;

public class MaximumSumOfTwoNonOverlappingSubarrays {
    // https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays
    /** Algorithm
        1. Use a window of size secondLen to move through the array.
            EG: [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2.
        2. At each step, check if on the left / right of this window exists an array with size firstLen.
            Add the windowSum to the max of left/right. Keep track of the maximum such pair (len1, len2) found.
        3. EG: - i = 6. Window of length 2= [8,9].
            Is there a window of size 3 on the left on i = 6? Yes, there are 4:[3,8,1],[8,1,3],[1,3,2],[3,2,1]
            The first and second ones are maximum.
            There is no 3 length array on the right of [8,9].
            So max = [3+8+1] + [8+9].
        4. As shown in #3, loop with i from 0 to nums.length - secondLen and match/max the current len2 window with the
            maximum len1 window on the left or right.
        5. It would not be efficient to traverse the array from 0..i-1 to find the max len1 array.
            You can cache the maximum len1 into an int[2][] : [0] will hold the rolling max from left ro right
            and [1] will hold the rolling max from right to left.
            This would give O(1) ability to know the max len1 window on the left/right.
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[][] firstLenSum = getFirstLenSums(nums, firstLen);
        return getMaxLenSum(nums, secondLen, firstLenSum);
    }

    private int getMaxLenSum(int[] nums, int secondLen, int[][] firstLenSum) {
        int maxSum = 0, currentSum = 0, onRight;
        for (int i = 0; i < secondLen; i++) {
            currentSum += nums[i];
        }
        onRight = firstLenSum[1][secondLen];
        maxSum = Math.max(maxSum, currentSum + onRight);
        for (int i = 1, j = secondLen; j < nums.length; i++, j++) {
            currentSum = currentSum - nums[i - 1] + nums[j];
            onRight = j < nums.length - 1 ? firstLenSum[1][j + 1] : 0;
            maxSum = Math.max(maxSum, currentSum + (Math.max(firstLenSum[0][i - 1], onRight)));
        }
        return maxSum;
    }

    private int[][] getFirstLenSums(int[] nums, int windowSize) {
        // sum[0] - maximum from left to right, sum[1] - max from right to left.
        int[][] sum = new int[2][nums.length];
        int currentLeftSum = 0, currentRightSum = 0;
        for (int i = 0, j = nums.length -1; i < windowSize; i++, j--) {
            currentLeftSum += nums[i];
            currentRightSum += nums[j];
        }
        sum[0][windowSize - 1] = currentLeftSum;
        sum[1][nums.length - windowSize] = currentRightSum;
        for (int i = windowSize, j = (nums.length - windowSize) -1; i < nums.length; i++, j--) {
            currentLeftSum = currentLeftSum - nums[i - windowSize] + nums[i];
            currentRightSum = currentRightSum - nums[j + windowSize] + nums[j];
            sum[0][i] = Math.max(sum[0][i-1], currentLeftSum);
            sum[1][j] = Math.max(sum[1][j+1], currentRightSum);
        }
        return sum;
    }
}
