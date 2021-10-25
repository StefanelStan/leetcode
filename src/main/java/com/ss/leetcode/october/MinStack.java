package com.ss.leetcode.october;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    // https://leetcode.com/problems/min-stack/
    private List<Integer> myStack;
    private int min = Integer.MAX_VALUE;
    private int minCount = 0;

    public MinStack() {
        myStack = new ArrayList<>();
    }

    public void push(int val) {
        myStack.add(val);
        if (myStack.size() == 1) {
            min = val;
            minCount = 1;
        } else {
            checkForMin(val);
        }
    }

    private void checkForMin(int val) {
        if (val < min) {
            min = val;
            minCount = 1;
        } else if (val == min) {
            minCount++;
        }
    }

    public void pop() {
        int returnVal = myStack.remove(myStack.size() - 1);
        if (returnVal == min) {
            if (minCount > 0) {
                minCount--;
            }
            if (minCount == 0 && !myStack.isEmpty()) {
                min = Integer.MAX_VALUE;
                for (int val : myStack) {
                    checkForMin(val);
                }
            }
        }
    }

    public int top() {
        return myStack.get(myStack.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
