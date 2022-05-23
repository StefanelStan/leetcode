package com.ss.leetcode.LC2022.may;

public class MaximizeSumOfArrayAfterKNegations {
    // https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
    /** Algorithm
         1. Use an array of size [201] to count the numbers. index 0..100 will hold -100..0
            and 101 to 200 will hold 1..100.
            So i - 100 will represent the real backed backed by index:
         2. Start from index 0 (representing -100) to index 99 (representing -1) or until K is 0.
            If count > 0, flip it: add it to sum (you have to multiply by 2) and also update the count of it's "mirror" count value index
             eg: value -3 will be under index 97. Flipping it means you add 2 * 3 to sum AND update the count of 100 - 97 + 100.
            (3 + 100 = 103. 103 will represent value 3).
            Also subtract from k the number of flipped numbers.
         3. If K is still greater than 0, then the lowest positive can be flipped, only if k is odd.
            Find the first positive (loop from 100 to 200). If k is odd, deduct its double value from sum.
         4. Return the sum.
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] count = new int[201];
        int sum = 0;
        for(int num : nums) {
            sum += num;
            count[num + 100]++;
        }
        int timesDeducted = 0;
        for (int i = 0; i < 100 && k > 0; i++) {
            if (count[i] > 0) {
                timesDeducted = Math.min(k, count[i]);
                sum += ((100 - i) * timesDeducted * 2);
                count[100 - i + 100] += timesDeducted;
                k -= timesDeducted;
            }
        }
        if (k > 0) {
            int firstPositive = 100;
            while (count[firstPositive] == 0) {
                firstPositive++;
            }
            if (k % 2 == 1) {
                sum -= 2 * (firstPositive - 100);
            }
        }
        return sum;
    }
}
