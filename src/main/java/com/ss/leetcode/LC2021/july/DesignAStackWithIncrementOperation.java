package com.ss.leetcode.LC2021.july;

public class DesignAStackWithIncrementOperation {
    // https://leetcode.com/problems/design-a-stack-with-increment-operation/
    private final int[] stack;
    private int currentIndex = -1;
    public DesignAStackWithIncrementOperation(int maxSize) {
        stack = new int[maxSize];
        currentIndex = 0;
    }

    public void push(int x) {
        if (currentIndex < stack.length) {
            stack[currentIndex] = x;
            currentIndex++;
        }
    }
    public int pop() {
        if(currentIndex == 0) {
            return -1;
        } else {
            return stack[--currentIndex];
        }
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, stack.length); i++) {
            stack[i] += val;
        }
    }
}
