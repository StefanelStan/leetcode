package com.ss.leetcode.LC2021.september;

public class ClimbingStairs {
    // https://leetcode.com/problems/climbing-stairs/
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int prev = 1, current = 2, index = 2;
        while (index < n) {
            current += prev;
            prev = current - prev;
            index++;
        }
        return current;
    }
}
