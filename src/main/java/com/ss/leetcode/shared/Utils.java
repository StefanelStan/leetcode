package com.ss.leetcode.shared;

public class Utils {
    public static int sumOfArray(int[] numbers) {
        int sum = 0;
        for(int nr : numbers) {
            sum += nr;
        }
        return sum;
    }
}
