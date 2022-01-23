package com.ss.leetcode.LC2022.january;

public class DayOfTheWeek {
    // https://leetcode.com/problems/day-of-the-week/
    /** Algorithm
     1. Declare some arrays to hold the weekdays (Thursday, friday, sat) and arrays to hold the default days in per month.
     2. Count the days starting from 1 jan 1971 (Which is Friday) until the given date. Pay attention to leap years.
     3. Return the day of week (array position) modulo 7.
     */
    private static final String[] weekDays = {"Thursday","Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday"};
    private static final int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    public String dayOfTheWeek(int day, int month, int year) {
        int days = 0;
        for (int i = 1971; i < year; i++) {
            days += (isLeapYear(i) ? 366 : 365);
        }
        boolean isLeapYear = isLeapYear(year);
        for (int i = 0; i < month - 1; i++) {
            if (i == 1 && isLeapYear) {
                days += 29;
            } else {
                days += monthDays[i];
            }
        }
        days += day;
        return weekDays[days%7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
