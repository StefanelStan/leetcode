package com.ss.leetcode.LC2023.february;

public class FindConsecutiveIntegersFromADataStream {
    // https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream
    /** Algorithm
        1. Count how many nums equal to value you have consicutively inserted until now
        2. If current num is not value, reset the count to 0;
        3. Return true only if count >= k;
     */
    private final int value;
    private final int k;
    private int count;
    public FindConsecutiveIntegersFromADataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        count = num == value ? count + 1 : 0;
        return count >= k;
    }
}
