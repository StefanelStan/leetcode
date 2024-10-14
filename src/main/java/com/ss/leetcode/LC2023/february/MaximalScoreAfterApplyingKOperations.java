package com.ss.leetcode.LC2023.february;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    // https://leetcode.com/problems/maximal-score-after-applying-k-operations
    /** Algorithm
        1. Sort the given nums on natural order.
        2. Use a PriorityQueue<> (reverseOrder()) - highest ones first to put the elements that have been polled from the array.
        3. Iterate from the last index and if last index >= headOfQueue, decrement i, add nums[i] to score and put ceil(double nums[i] / 3) to queue.
        4. Else, if the head of the queue > nums[i], poll from queue and add that bonus.
        5. Stop when k reaches 0 OR the score you have added is 0 (no point in adding 0s to the score)
     */
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        Arrays.sort(nums);
        int toPutBack = 0, addedScore = 1;
        PriorityQueue<Integer> afterApplications = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = nums.length - 1; k > 0 && addedScore > 0; k--) {
            if (afterApplications.isEmpty() || (i >= 0 && nums[i] >= afterApplications.peek())) {
                toPutBack = (int)Math.ceil((double)nums[i] / 3);
                addedScore = nums[i];
                i--;
            } else {
                addedScore = afterApplications.peek();
                toPutBack = (int)Math.ceil((double)afterApplications.poll() / 3);
            }
            score += addedScore;
            afterApplications.add(toPutBack);
        }
        return score;
    }


    /** Algorithm
        1. Use a priorityQueue with reverse comparator to add nums
        2. For K steps: add queue.poll() to score and put back the ceiling (poll/3).
        3. Return the answer;
     */
    public long maxKelements2(int[] nums, int k) {
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
