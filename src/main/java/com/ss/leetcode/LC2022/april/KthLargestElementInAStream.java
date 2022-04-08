package com.ss.leetcode.LC2022.april;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/
    private final PriorityQueue<Integer> stream;
    private final int size;
    public KthLargestElementInAStream(int k, int[] nums) {
        stream = new PriorityQueue<>();
        size = k;
        for (int num : nums) {
            stream.add(num);
        }
        while(stream.size() > size) {
            stream.poll();
        }
    }

    public int add(int val) {
        stream.add(val);
        if(stream.size() > size) {
            stream.poll();
        }
        return stream.peek();
    }
}
