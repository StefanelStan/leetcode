package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.february.NumberOfDaysBetweenTwoDates;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

        start.numberOfDaysBetweenTwoDates();
    }

    public void numberOfDaysBetweenTwoDates() {
        NumberOfDaysBetweenTwoDates nodbtd = new NumberOfDaysBetweenTwoDates();

        System.out.println("1 == " + nodbtd.daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println("15 == " + nodbtd.daysBetweenDates("2020-01-15", "2019-12-31"));
        System.out.println("5 == " + nodbtd.daysBetweenDates("2004-02-25", "2004-03-01"));
        System.out.println("35068 == " + nodbtd.daysBetweenDates("2004-02-25", "2100-03-01"));
    }
}
