package com.ss.leetcode.LC2021.august;

public class DayOfTheYear {
    // https://leetcode.com/problems/day-of-the-year/
    private static final int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int dayOfYear(String date) {
        int dayOfYear = 0;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        for (int i = 1; i < month; i++) {
            dayOfYear += daysPerMonth[i-1];
        }
        if (isLeapYear(year) && month > 2) {
            dayOfYear++;
        }
        dayOfYear += day;
        return dayOfYear;
    }

    private boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
}
