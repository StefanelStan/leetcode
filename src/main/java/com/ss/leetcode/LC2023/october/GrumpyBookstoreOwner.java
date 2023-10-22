package com.ss.leetcode.LC2023.october;

public class GrumpyBookstoreOwner {
    //  https://leetcode.com/problems/grumpy-bookstore-owner
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxSatisfied = 0, windowMaxSatisfaction = 0, windowSatisfaction = 0;
        int totalSatisfied = getDefaultTotalSatisfied(customers, grumpy);
        for (int i = 0; i < minutes; i++) {
            windowMaxSatisfaction += customers[i];
            windowSatisfaction += customers[i] * (grumpy[i] == 1 ? 0 : 1);
        }
        maxSatisfied = windowMaxSatisfaction + totalSatisfied - windowSatisfaction;
        for (int i = 1, j = minutes; j < customers.length; i++, j++) {
            windowMaxSatisfaction += customers[j] - customers[i - 1];
            windowSatisfaction += (customers[j] * (grumpy[j] == 1 ? 0 : 1) - customers[i-1] * (grumpy[i-1] == 1 ? 0 : 1));
            maxSatisfied = Math.max(maxSatisfied, windowMaxSatisfaction + totalSatisfied - windowSatisfaction);
        }
        return maxSatisfied;
    }

    private int getDefaultTotalSatisfied(int[] customers, int[] grumpy) {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            total += customers[i] * (grumpy[i] == 1 ? 0 : 1);
        }
        return total;
    }
}
