package com.ss.leetcode.LC2023.february;

public class FindTheArrayConcatenationValue {
    // https://leetcode.com/problems/find-the-array-concatenation-value
    /** Algorithm
         1. Use two pointers left and right to traverse the array and concatenate numbers
        2. Concatenation: as we observe, [52, 43] is actually 52 * 100 + 43 = 5243
            [52, 432] = 52 * 1000 + 432 = 52432
        3. The value of the right operand will determine the power of 10 multipliction.
            [right] <10   => [left] * 10 + [right]
            [right] <100  => [left] * 100 + [right]
            ....
            [right] < 10000=> [left] * 10000 + [right]
             else [left] * 100000 + [right].
        4. At the end, if left == right (length is odd), also add the left to the answer.
     */
    public long findTheArrayConcVal(int[] nums) {
        long value = 0;
        int low = 0, high = nums.length -1;
        while(low < high) {
            value += nums[low] * multiplier(nums[high]) + nums[high];
            low++;
            high--;
        }
        if (low == high) {
            value += nums[low];
        }
        return value;
    }

    private int multiplier(int value) {
        int multiplier;
        if (value < 10) {
            multiplier = 10;
        } else if (value < 100) {
            multiplier = 100;
        } else if (value < 1000) {
            multiplier = 1000;
        } else if (value < 10000) {
            multiplier = 10000;
        } else {
            multiplier = 100000;
        }
        return multiplier;
    }
}
