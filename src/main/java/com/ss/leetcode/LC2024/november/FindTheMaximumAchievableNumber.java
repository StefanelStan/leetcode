package com.ss.leetcode.LC2024.november;

public class FindTheMaximumAchievableNumber {
    // https://leetcode.com/problems/find-the-maximum-achievable-number
    /** Algorithm
        1. If you can increment num by 1 and decrement the target by 1 ..this t times, it means the diff between target and num is 2 *t;
        2. Return num + 2 * t;
     */
    public int theMaximumAchievableX(int num, int t) {
        return num +2 * t;
    }
}
