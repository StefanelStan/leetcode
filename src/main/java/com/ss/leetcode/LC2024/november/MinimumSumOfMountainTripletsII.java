package com.ss.leetcode.LC2024.november;

public class MinimumSumOfMountainTripletsII {
    // https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii
    /** Algorithm
        1. Your min Mountain sum will be given by the min on left + min on right + current number, if current num > minOnLeft && > minOnRight
        2. Use an int[n] and calculate the minOnLeft for the entire array
        3. Traverse nums from n-2 to 1 and if curr > minOnLeft[i-1] and curr > minOnRight, set the min mountainSum.
            - Also adjust the minOnRight to be the min between curr and minOnRight.
        4. Return mountainSum or -1 if no sum was found.
     */
    public int minimumSum(int[] nums) {
        int minMountainSum = Integer.MAX_VALUE;
        int minOnRight = nums[nums.length - 1];
        int[] minsOnLeft = new int[nums.length];
        minsOnLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minsOnLeft[i] = Math.min(minsOnLeft[i-1], nums[i]);
        }
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] > minsOnLeft[i-1] && nums[i] > minOnRight) {
                minMountainSum = Math.min(minMountainSum, minsOnLeft[i-1] + nums[i] + minOnRight);
            }
            minOnRight = Math.min(minOnRight, nums[i]);
        }
        return minMountainSum == Integer.MAX_VALUE ? -1 : minMountainSum;
    }
}
