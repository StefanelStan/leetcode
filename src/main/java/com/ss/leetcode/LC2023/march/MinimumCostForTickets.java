package com.ss.leetcode.LC2023.march;

public class MinimumCostForTickets {
    // https://leetcode.com/problems/minimum-cost-for-tickets
    /** Algorithm
        1. For each day in calendar (1-365) that overlaps with the given days[], determine what is cheaper
            (calendar[i] == days[j])
            - to buy 1day ticket and pay 1dayPAss cost + the total cost until this day
            - to buy 7days pass and pay 7daysPass + the total cost until current day - 7
            - to buy 30daysPass and pay 30daysPass cost + the total cost until current day - 30?
        2. If calendar[i] does not overlap days[j] then just copy the cost from calendar[i-1] to calendar[i]
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dailyCost = new int[366];
        int dailyCostIndex = 0, dayIndex = 0;
        int oneDayPass, sevenDaysPass, thirtyDaysPass;
        while(dayIndex < days.length) {
            dailyCostIndex++;
            if (days[dayIndex] == dailyCostIndex) {
                oneDayPass = dailyCost[dailyCostIndex - 1] + costs[0];
                sevenDaysPass = costs[1] + dailyCost[Math.max(0, dailyCostIndex - 7)];
                thirtyDaysPass = costs[2] + dailyCost[Math.max(0, dailyCostIndex - 30)];
                dailyCost[dailyCostIndex] = Math.min(oneDayPass, Math.min(sevenDaysPass, thirtyDaysPass));
                dayIndex++;
            } else {
                dailyCost[dailyCostIndex] = dailyCost[dailyCostIndex - 1];
            }
        }
        return dailyCost[dailyCostIndex];
    }
}
