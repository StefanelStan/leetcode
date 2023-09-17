package com.ss.leetcode.LC2023.september;

import java.util.Arrays;

public class RearrangeArrayToMaximizePrefixScore {
    // https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score
    /** Algorithm
        1. As the problem states, it wants you to carefully build an array of prefix sums and count how many positive elements does this array have
        2. EG: -5,-6,4,3,1,2,4
            Its prefix sum is [-5,-11,-7,-4,-3,-1,3]. This has only 1 positive sum/element
        3. What if you sort this the input array?
            4,4,3,2,1,-5,-6 => prefix sum array: [4,8,11,13,14,9,3]
        4. As you can see, ordering it and traversing it from max to min would give a better count of positive sum
        5. Sort the array (Arrays.sort sorts it in increasing order)
        6. From max to min, calculate the prefixSum. Stop when prefixSum reaches 0 or below
            Keep a counter of how many steps you have made with a positive prefixSum.
        7. Return number of steps.
     */
    public int maxScore(int[] nums) {
        int maxScore = 0;
        long currentSum = 0;
        Arrays.sort(nums);
        for (int i = nums.length -1; i >= 0; i--) {
            currentSum += (long)nums[i];
            if (currentSum > 0) {
                maxScore++;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
