package com.ss.leetcode.LC2025.february;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {
    // https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii
    /** Algorithm
        1. Use a PriorityQueue<Long> and put all the numbers. The lowest ones will be the the front
        2. While the head to PQ is less than k:
            - pull first 2 numbers and add their sum based on forumula
            - increment steps
        3. Return number of steps.
     */
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long first, second;
        for (int num :nums) {
            minHeap.add((long)num);
        }
        while (minHeap.peek() < k) {
            first = minHeap.poll();
            second = minHeap.poll();
            minHeap.add(2 * Math.min(first, second) + Math.max(first, second));
            operations++;
        }
        return operations;
    }
}
