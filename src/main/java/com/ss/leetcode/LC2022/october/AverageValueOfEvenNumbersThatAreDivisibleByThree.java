package com.ss.leetcode.LC2022.october;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    // https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
    /** Algorithm
         1. Use a sum and count to add / count the target nums
         2. For each num, if num is divisible by 6, add and count it
         3. If count != 0, return the sum / count, 0 otherwise.
     */
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return count != 0 ? sum / count : count;
    }
}
