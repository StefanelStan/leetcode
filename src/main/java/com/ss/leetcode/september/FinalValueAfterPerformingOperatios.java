package com.ss.leetcode.september;

public class FinalValueAfterPerformingOperatios {
    // https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
    public int finalValueAfterOperations(String[] operations) {
        int xValue = 0;
        for (String operation : operations) {
            if (operation.contains("-")) {
                xValue--;
            } else {
                xValue++;
            }
        }
        return xValue;
    }
}
