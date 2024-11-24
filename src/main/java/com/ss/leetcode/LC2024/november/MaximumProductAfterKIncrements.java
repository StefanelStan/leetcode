package com.ss.leetcode.LC2024.november;

import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {
    // https://leetcode.com/problems/maximum-product-after-k-increments
    /** Algorithm
        1. You need to increment the lowest numbers by 1, as  they will provide the biggest boost in product
        2. Add all numbers in a priorityQueue
        3. While k > 0, poll the head and add back to queue the head + 1
        4. Traverse the modified queue and multiply them, doing modulo each time.
     */
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        for (int num : nums) {
            sorted.add(num);
        }
        while (k-- > 0) {
            sorted.add(1 + sorted.poll());
        }
        long product = 1;
        while (!sorted.isEmpty() && product > 0) {
            product = (product * sorted.poll()) % 1_000_000_007;
        }
        return (int)product;
    }
}
