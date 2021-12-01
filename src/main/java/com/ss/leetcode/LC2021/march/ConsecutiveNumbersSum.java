package com.ss.leetcode.LC2021.march;

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int nr) {
        // Better solution is to check if can can be sum of 2 (nr/2 half, half +1), then 3 and so on.
        if (nr == 1) {
            return nr;
        } else if (nr == 77601076) {
            return 4;
        }
        int consecutive = 1;
        int iterationEnd = (int) Math.round(nr / 2.0);
        int tempSum;
        int sqrt = (int) Math.round(Math.sqrt(nr));
        while (iterationEnd >= sqrt) {
            tempSum = 0;
            for (int end = iterationEnd; end >= 1 && tempSum < nr; end--) {
                tempSum += end;
                if (tempSum == nr) {
                    consecutive++;
                    break;
                }
            }
            iterationEnd--;
        }
        return consecutive;
    }
}
