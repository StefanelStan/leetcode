package com.ss.leetcode.LC2023.october;

public class GrumpyBookstoreOwner {
    //  https://leetcode.com/problems/grumpy-bookstore-owner
    /** Algorithm
        1. Looking at the minutes parameter, we understand that for a given minutes WINDOW, all the customers
            will give max possible satisfaction.
        2. For a given customers [0...n] we can use minutes or [i..k] WINDOW to maximize satisfaction.
        3. Thus, if we use the minutes from i to k to apply the trick, the total satisfaction we get is
            defaultSatisfaction[0..i-1] + customers[i..k] + defaultSatisfaction[k+1..n]
        4. Traverse the while array and determine the totalDefaultSatisfaction
        5. Traverse the array again with a WINDOW [i,j] i = 0, j = minutes-1 and determine
            - the windowDefaultSatisfaction
            - the windowMaxSatisfaction
            - your best satisfaction will be windowMaxSatisfaction + totalDefaultSatisfaction - windowDefaultSatisfaction
        6. Readjust the window (windowDefaultSatisfaction, windowMaxSatisfaction) each time you move to the right.
     */
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
