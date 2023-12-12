package com.ss.leetcode.LC2023.december;

public class MaximumAbsoluteSumOfAnySubarray {
    // https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray
    /** Algorithm
        1. In order to find max sum subarray, your subarray must have the highest positive subsum or lowest negative subsum.
        2. Supposing you have the numbers: -3, -4, 0, 5, -2, 10
            - As we traverse, we obtain the prefixsum -3, -7, -7, -2, -4, 6.
        3. We observe that we have a positive sum: 6 for the chain of indices [0,1,2,3,4,5].
        4. Do we have any negative prefim sums along the way? If we remove that negative prefim sum (prefix chain), we could end up with a larger sum
            - We have prefixSum of -3. If we remove -3 from 6 we obtain 9. (6 - -3 = 9) 9 is the subchain sum from index [1..5].
            - Is -3 the best choice? What if we select the LOWEST negative prefix sum encountered so far?
            - That is -7. So 5 - -7 = 12. Between indices [3,4,5] we have a subsub of 12.
        5. As we observe, if your current/PrefixSum is positive, you need to remove the lowest negative Sum removing it, would turn into a positive (5 - -7 = 12)
        6. If your current prefix sum if negative, then you need to remove the highest positive prefix sum
            - EG: 3,4,-5,-3 -> prefixsum : 3,7,2,-1.
            -1 - 7 = -8.  abs(-8) = 8
        7. Traverse the array, keeping track of lowestNegativeSum and highestPositiveSum.
     */
    public int maxAbsoluteSum(int[] nums) {
        int highestPositiveSum = 0, lowestNegativeSum = 0;
        int maxAbsoluteSum = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            maxAbsoluteSum = Math.max(maxAbsoluteSum,
                findAbsoluteSum(currentSum, highestPositiveSum, lowestNegativeSum));
            highestPositiveSum = Math.max(highestPositiveSum, currentSum);
            lowestNegativeSum = Math.min(lowestNegativeSum, currentSum);
        }
        return maxAbsoluteSum;
    }

    private int findAbsoluteSum(int currentSum, int highestPositiveSum, int lowestNegativeSum) {
        return currentSum >= 0
            ? Math.abs(currentSum - lowestNegativeSum) : Math.abs(currentSum - highestPositiveSum);
    }
}
