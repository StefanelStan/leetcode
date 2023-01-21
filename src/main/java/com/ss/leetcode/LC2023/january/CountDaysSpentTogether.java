package com.ss.leetcode.LC2023.january;

public class CountDaysSpentTogether {
    /** Algorithm
        1. Determine the day number of the year alice and bob arrived/leaved. eg: 02-15 -> 46th day of the year.
        2. The nr of days together is the overlapping interval between Min(aliceDepart, bobDepart) - Max(aliceArrive, bobArrive) + 1;
        3. Return the max between 0 and the above difference.
     */
    private final int[] months = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        return Math.max(0, (Math.min(getDays(leaveAlice), getDays(leaveBob)) -
            Math.max(getDays(arriveAlice), getDays(arriveBob))) + 1);
    }

    private int getDays(String date) {
        int days = 0;
        for (int i = 1; i < Integer.parseInt(date.substring(0,2)); i++) {
            days += months[i];
        }
        days += Integer.parseInt(date.substring(3));
        return days;
    }
}
