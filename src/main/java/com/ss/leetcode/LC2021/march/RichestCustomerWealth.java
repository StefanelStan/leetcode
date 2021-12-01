package com.ss.leetcode.LC2021.march;

public class RichestCustomerWealth {
    // https://leetcode.com/problems/richest-customer-wealth/
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int currentAccount = 0;
        for (int[] banks : accounts) {
            currentAccount = 0;
            for (int bank : banks) {
                currentAccount += bank;
            }
            if (currentAccount > max) {
                max = currentAccount;
            }
        }
        return max;
    }
}
