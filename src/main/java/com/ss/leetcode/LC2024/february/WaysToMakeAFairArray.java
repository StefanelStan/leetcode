package com.ss.leetcode.LC2024.february;

public class WaysToMakeAFairArray {
    // https://leetcode.com/problems/ways-to-make-a-fair-array/description
    /** Algorithm
        1. You need to know the totalEven and totalOdd indices sum.
        2. For each index i, if you remove it, the odd indices becomes even and even indices become odd on the remaining RIGHT side of the array.
        3. With each index i, treaverse and keep track of cumulativeOdd / evenSum
        4. If i is odd, then your "new" odd sum is the sum of cumulativeOdd and the remaining even sum from index i,
            because ALL the even elements get shifted to ODD positions. Apply the opposite logic to detect the "new" even sum.
        5. If the "new" odd sum == "new" even sum, increment total ways.
     */
    public int waysToMakeFair(int[] nums) {
        int totalOddSum = 0, totalEvenSum = 0, cumulativeOddSum = 0, cumulativeEvenSum = 0;
        int ways = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                totalEvenSum += nums[i];
            } else {
                totalOddSum += nums[i];
            }
        }
        boolean isFair = false;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) { // even index
                isFair = cumulativeEvenSum + totalOddSum - cumulativeOddSum == cumulativeOddSum + ((totalEvenSum - nums[i]) - cumulativeEvenSum);
                cumulativeEvenSum += nums[i];
            } else {
                isFair = cumulativeEvenSum + ((totalOddSum - cumulativeOddSum) - nums[i]) == cumulativeOddSum + totalEvenSum -  cumulativeEvenSum;
                cumulativeOddSum += nums[i];
            }
            ways += isFair ? 1 : 0;
        }
        return ways;
    }
}
