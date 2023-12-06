package com.ss.leetcode.LC2021.september;

public class CalculateMoneyInLeetcodeBank {
    // https://leetcode.com/problems/calculate-money-in-leetcode-bank/
    public int totalMoney(int n) {
        int completedWeeks = n / 7, weekBonus = Math.max(0, completedWeeks -1);
        int day = n % 7;
        int totalFromWeeks = completedWeeks * 28 + 7 * (weekBonus * (weekBonus + 1) / 2);
        int totalFromDayOfWeek = day * (day + 1) / 2 + (completedWeeks * day);
        return totalFromWeeks + totalFromDayOfWeek;
    }

    public int totalMoney2(int n) {
        int nrOfWeeks = (n -1) / 7;
        int dayOfWeek = n % 7 == 0 ? 7 : n % 7;

        int total = nrOfWeeks * 28 + getWeekExtra(nrOfWeeks -1);
        for (int i = 1; i <= dayOfWeek; i++) {
            total += i + nrOfWeeks;
        }
        return total;
    }

    private int getWeekExtra(int weeks) {
        int totSum = 0;
        int weekSum = 0;
        int index = 1;
        while(index++ <= weeks) {
            weekSum += 7;
            totSum += weekSum;
        }
        return totSum;
    }
}
