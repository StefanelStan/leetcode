package com.ss.leetcode.LC2023.february;

public class NumberOfDaysBetweenTwoDates {
    // https://leetcode.com/problems/number-of-days-between-two-dates
    /** Algorithm
        1. Get the number of days that have passed since 1970 until date1 and date2
        2. The answer is Math.abs(diff1 - diff2);
     */
    int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDays(date1) - getDays(date2));
    }

    private int getDays(String dateStr) {
        int year = Integer.parseInt(dateStr.substring(0,4));
        int month = Integer.parseInt(dateStr.substring(5,7));
        int days = Integer.parseInt(dateStr.substring(8));
        return getYearDays(year - 1) + getMonthDays(month - 1, year) + days;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    private int getYearDays(int to) {
        int sum = 0;
        while (to >= 1971) {
            sum += isLeapYear(to--) ? 366 : 365;
        }
        return sum;
    }

    private int getMonthDays(int upTo, int year) {
        int days = 0;
        for (int i = 0; i < upTo; i++) {
            days += monthDays[i];
            if (i == 1 && isLeapYear(year)) {
                days++;
            }
        }
        return days;
    }
}
