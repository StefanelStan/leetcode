package com.ss.leetcode.LC2021.february;

import java.util.Arrays;

public class MaximumOfAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int maxAbsValue = 0;
        int currentAbsValue = 0;
        int stop = Math.min(50, arr1.length);
        for (int i = 0, j = arr1.length - 1; i < stop; i++, j--) {
            currentAbsValue = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + (j - i);
            if (currentAbsValue > maxAbsValue) {
                maxAbsValue = currentAbsValue;
            }
        }
        return maxAbsValue;
    }
}
