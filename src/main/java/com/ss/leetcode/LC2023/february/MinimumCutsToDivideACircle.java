package com.ss.leetcode.LC2023.february;

public class MinimumCutsToDivideACircle {
    // https://leetcode.com/problems/minimum-cuts-to-divide-a-circle
    /** Algorithm
         1. If n == 1, 0 cuts are needed
         2. Else if n is even, you need n/ 2 cuts (due to cuts intersection, each cut will give 2 slices)
         3. Else (n is odd) you need n number of cuts.
     */
    public int numberOfCuts(int n) {
        return n == 1 ? 0 : n % 2 == 1 ? n : n / 2;
    }
}
