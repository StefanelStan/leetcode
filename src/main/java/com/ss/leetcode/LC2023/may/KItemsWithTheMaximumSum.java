package com.ss.leetcode.LC2023.may;

public class KItemsWithTheMaximumSum {
    // https://leetcode.com/problems/k-items-with-the-maximum-sum
    /** Algorithm
        1. From each bag you can collect = max(k, bagSize) items. The sum will be incremented by the collected * bagValue.
            - Also, as you have picked up collected items, deduct collected from k.
            - EG: [5,2,8] k = 3.
                - collected = Math.min(3, 5) = 3. bag value = 1 => sum += 3 * 1 = 3, k = 3-3 (0)
                - collected = Math.min(0, 2) => 0. bag value = 0 => sum += 0 * 0 = 0. k = 0-0 = 0
                - collected = Math.min(0, 8) => 0. bag value = -1 => sum += 0 * -1 = 0, k = 0-0.
            - totalSum = 3.
        2. This method is preferred rather than if k > =.. else, if k > 0 else..
     */
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int[] total = {0};
        k -= collect(numOnes, 1, k, total);
        k -= collect(numZeros, 0, k, total);
        k -= collect(numNegOnes, -1, k, total);
        return total[0];
    }

    private int collect(int bag, int value, int k, int[] total) {
        int toCollect = Math.min(k, bag);
        total[0] += (toCollect * value);
        return toCollect;
    }
}
