package com.ss.leetcode.june;

public class XOROperationInAnArray {
    // https://leetcode.com/problems/xor-operation-in-an-array/
    public int xorOperation(int n, int start) {
        int current = start;
        for (int i = 1; i < n; i++) {
            current = current ^ (2 * i + start);
        }
        return current;
    }
}
