package com.ss.leetcode.LC2023.august;

public class MinimumPenaltyForAShop {
    // https://leetcode.com/problems/minimum-penalty-for-a-shop
    public int bestClosingTime(String customers) {
        int nOnLeft = 0, nOnRight = countN(customers);
        int yOnRight  = customers.length() - nOnRight;
        int minPenalty = Integer.MAX_VALUE, candidate, minPenaltyIndex = 0;
        for (int i = 0; i <= customers.length(); i++) {
            candidate = nOnLeft + yOnRight;
            if (i < customers.length()) {
                if (customers.charAt(i) == 'Y') {
                    yOnRight--;
                } else {
                    nOnLeft++;
                    nOnRight--;
                }
            }
            if (candidate < minPenalty) {
                minPenalty = candidate;
                minPenaltyIndex = i;
            }
        }
        return minPenaltyIndex;
    }

    private int countN(String customers) {
        int count = 0;
        for (int  i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') {
                count++;
            }
        }
        return count;
    }
}
