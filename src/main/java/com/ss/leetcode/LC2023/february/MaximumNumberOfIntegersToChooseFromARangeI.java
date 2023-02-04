package com.ss.leetcode.LC2023.february;

public class MaximumNumberOfIntegersToChooseFromARangeI {
    // https://leetcode.com/contest/biweekly-contest-97/problems/maximum-number-of-integers-to-choose-from-a-range-i/
    /** Algorithm
        1. Use a boolean[] present of size n to map which number from banned are present
        2. Start from 1 to n. If number is not present (not banned) AND adding it to a rollingSum doesn't go over maxsum,
            add it and increase the count of numbers. Break if sum exceeds maxSum
        3. Return the count;
     */
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] present = mapPresent(banned, n);
        int maxCount = 0, tempSum = 0;
        for(int i =1; i <= n; i++) {
            if (!present[i]) {
                if (tempSum + i <= maxSum) {
                    tempSum += i;
                    maxCount++;
                } else {
                    break;
                }
            }
        }
        return maxCount;
    }

    private boolean[] mapPresent(int[] banned, int n) {
        boolean[] present = new boolean[n+1];
        for (int num : banned) {
            if(num <= n) {
                present[num] = true;
            }
        }
        return present;
    }
}
