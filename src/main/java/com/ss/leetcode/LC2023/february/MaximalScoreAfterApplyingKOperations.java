package com.ss.leetcode.LC2023.february;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    // https://leetcode.com/problems/maximal-score-after-applying-k-operations
    /** Algorithm
        1. Use a priorityQueue with reverse comparator to add nums
        2. For K steps: add queue.poll() to score and put back the ceiling (poll/3).
        3. Return the answer;
     */
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> ordered = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for (int num : nums) {
            ordered.add(num);
        }
        while(k > 0) {
            score += ordered.peek();
            ordered.add((int)Math.ceil((double) ordered.poll() / 3));
            k--;
        }
        return score;
    }
}
