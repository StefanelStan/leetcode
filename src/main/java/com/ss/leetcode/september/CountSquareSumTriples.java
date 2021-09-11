package com.ss.leetcode.september;

public class CountSquareSumTriples {
    // https://leetcode.com/problems/count-square-sum-triples/
    public int countTriples(int n) {
        int triples = 0;
        if (n < 3) {
            return 0;
        }
        int[] squares = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            squares[i] = i * i;
        }
        int tempSum = 0;
        for (int i = n; i >= 3; i--) {
            int low = 1, high = i - 1;
            while (low < high) {
                tempSum = squares[low] + squares[high];
                if (tempSum == squares[i]) {
                    triples += 2;
                    low++;
                    high--;
                } else if (tempSum > squares[i]) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return triples;
    }
}
