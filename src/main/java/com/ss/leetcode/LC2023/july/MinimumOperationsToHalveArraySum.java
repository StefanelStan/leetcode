package com.ss.leetcode.LC2023.july;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {
    // https://leetcode.com/problems/minimum-operations-to-halve-array-sum
    /** Algorithm
        1. In order to obtain the minimum number of steps, you need to operate over the highest numbers first
        2. Add the numbers in a PriorityQueue<Double> in reverse order (highest numbers first)
           Also, compute their sum (and halfSum)
        3. While sum > halfSum
            - poll from queue (highest)
            - half that number
            - deduct that half from sum and add it back in queue queue
            - increase the number of steps
        4. Break when sum <= halfSum. Return the steps.
     */
    public int halveArray(int[] nums) {
        int steps = 0;
        double current;
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0, halfSum = 0;
        for (int num : nums) {
            queue.add((double) num);
            sum += num;
        }
        halfSum = sum / 2;
        while(sum > halfSum) {
            current = queue.poll();
            current = current / 2;
            sum -= current;
            queue.add(current);
            steps++;
        }
        return steps;
    }
}
