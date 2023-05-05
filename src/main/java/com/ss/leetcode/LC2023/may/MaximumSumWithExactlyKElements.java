package com.ss.leetcode.LC2023.may;

public class MaximumSumWithExactlyKElements {
    // https://leetcode.com/problems/maximum-sum-with-exactly-k-elements
    /** Algorithm
        1. Find the max within the nums
        2. As we observe, the steps involving taking max and adding 1 to it for (k-1) times
            EG: [3,5,1] k = 5. => Select 5 and make the sum 5 + 6 + 7 + 8 + 9
        3. We observe that with each step we add 1 to max, so we have
             max, max +1, max + 2, max + 3, max + 4.
        4. We can observe that we have max * k and the sum of first (k-1) natural numbers
            (k-1) * k / 2;
        5. Return the answer.
     */
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max * k + ((k-1) * k / 2);
    }
}
