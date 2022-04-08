package com.ss.leetcode.LC2021.december;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    // https://leetcode.com/problems/kth-largest-element-in-an-array/
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> numbers = new PriorityQueue<>();
        for (int nr : nums) {
            numbers.offer(nr);
            if(numbers.size() > k) {
                numbers.poll();
            }
        }
        return numbers.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> numbers = new PriorityQueue<>();
        for (int nr : nums) {
            numbers.offer(nr);
            if(numbers.size() > k) {
                break;
            }
        }
        int kthLargest = 0;
        for (int i = 0; i < k; i++) {
            kthLargest = numbers.poll();
        }

        return kthLargest;
    }
}
