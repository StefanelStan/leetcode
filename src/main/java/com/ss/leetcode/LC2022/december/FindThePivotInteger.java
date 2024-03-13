package com.ss.leetcode.LC2022.december;

public class FindThePivotInteger {
    // https://leetcode.com/problems/find-the-pivot-integer
    // PRO MODE: Binary Search
    public int pivotInteger(int n) {
        int left = 1, right = n;
        int pivotLeftSum, pivotRightSum, pivot;
        int totalSum = n * (n + 1) / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2 ;
            pivotLeftSum = pivot * (pivot + 1) / 2;
            pivotRightSum = pivot + totalSum - pivotLeftSum;
            if (pivotLeftSum == pivotRightSum) {
                return pivot;
            } else if (pivotLeftSum < pivotRightSum) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    /** Algorithm
         1. Determine the sum of first n natural numbers
         2. Use a partialSum int to keep track the the current partial sum;
         3. Loop from i from 1 to n or partialSum <= totalSum/2.
            - if partialSum + i == totalSum - partialSum return i
         -   return -1 by default
     */
    public int pivotInteger2(int n) {
        int totalSum = n * (n + 1) / 2;
        int partialSum = 0;
        for (int i = 1; i <= n && partialSum <= totalSum / 2; i++) {
            if (partialSum + i == totalSum - partialSum) {
                return i;
            }
            partialSum += i;
        }
        return -1;
    }
}
