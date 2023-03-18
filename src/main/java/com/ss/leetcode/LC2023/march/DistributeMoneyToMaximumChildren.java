package com.ss.leetcode.LC2023.march;

public class DistributeMoneyToMaximumChildren {
    // https://leetcode.com/problems/distribute-money-to-maximum-children/
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        int given = 0;
        while (money >= 8 && children > 0 && money - 8 >= children - 1) {
            money -= 8;
            children--;
            given++;
        }
        if (money > 0 && children == 0) {
            given--;
        } else  if (money == 4 && children == 1) {
            given = Math.max(given - 1, 0);
        }
        return given;
    }
}
