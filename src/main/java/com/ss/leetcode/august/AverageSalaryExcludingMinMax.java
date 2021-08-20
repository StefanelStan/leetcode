package com.ss.leetcode.august;

public class AverageSalaryExcludingMinMax {
    // https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
    public double average(int[] salary) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int sal : salary) {
            sum += sal;
            max = Math.max(max, sal);
            min = Math.min(min, sal);
        }
        return ((double) (sum - (min + max))) / (salary.length - 2);
    }
}
