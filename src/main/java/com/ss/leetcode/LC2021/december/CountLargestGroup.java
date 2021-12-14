package com.ss.leetcode.LC2021.december;

public class CountLargestGroup {
    // https://leetcode.com/problems/count-largest-group/
    public int countLargestGroup(int n) {
        int[] digitSum = new int[37];
        for (int i = 1; i <= n; i++) {
            digitSum[getDigitSum(i)]++;
        }
        int maxGroup = 0, maxGroupCount = 0;
        for (int sum : digitSum) {
            if (sum > maxGroup) {
                maxGroup = sum;
                maxGroupCount = 1;
            } else if (sum == maxGroup) {
                maxGroupCount++;
            }
        }
        return maxGroupCount;
    }

    private int getDigitSum(int nr) {
        int sum = 0;
        while(nr > 0) {
            sum += (nr % 10);
            nr /= 10;
        }
        return sum;
    }
}
