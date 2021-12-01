package com.ss.leetcode.LC2021.august;

public class IncrementalMemoryLeak {
    // https://leetcode.com/problems/incremental-memory-leak/
    public int[] memLeak(int memory1, int memory2) {
        int second = 1;
        while(true) {
            if (memory1 >= memory2) {
                if (memory1 < second) {
                    break;
                }
                memory1 -= second;
            } else {
                if (memory2 < second) {
                    break;
                }
                memory2 -= second;
            }
            second++;
        }
        return new int[]{second, memory1, memory2};
    }
}
