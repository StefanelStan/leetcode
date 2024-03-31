package com.ss.leetcode.LC2024.march;

public class DetermineTheMinimumSumOfAKAvoidingArray {
    // https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array
    /** Algorithm
        1. EG: n = 5, k = 6.
            - If you add 1, then you cannot add 5 (because 1+4 = 5)
            - If you add 2, you cannot add 4
            - But you can add 3, then 6,7..
        2. You can add numbers that are <= k/2 OR >= k.
        3. Iterate from 1, stopping when you added n numbers.
        4. IF current number <= k/2 OR >= k, add it
        5. Return the sum
     */
    public int minimumSum(int n, int k) {
        int sum = 0;
        for (int i = 1, added = 0; added < n; i++) {
            if (i >= k || i <= k/2) {
                sum += i;
                added++;
            }
        }
        return sum;
    }
}
