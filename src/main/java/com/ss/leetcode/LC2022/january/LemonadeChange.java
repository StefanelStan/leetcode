package com.ss.leetcode.LC2022.january;

public class LemonadeChange {
    // https://leetcode.com/problems/lemonade-change/
    public boolean lemonadeChange(int[] bills) {
        int[] coins = {0, 0, 0};
        int restToGive;
        for (int i = 0; i < bills.length && coins[0] >= 0; i++) {
            coins[bills[i] / 10]++;
            restToGive = bills[i] - 5;
            if (restToGive == 15 && coins[1] > 0) {
                coins[1]--;
                restToGive -= 10;
            }
            coins[0] -= restToGive / 5;
        }
        return coins[0] >= 0;
    }


    public boolean lemonadeChange2(int[] bills) {
        int fives = 0, tens = 0;
        int change;
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else {
                change = bill - 5;
                if (change == 5) {
                    fives--;
                    tens++;
                } else { // change is 15 - dispose the 10 first
                    if (tens > 0 && fives > 0) {
                        tens--;
                        fives--;
                    } else {
                        fives -= 3;
                    }
                }
                if (fives < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
