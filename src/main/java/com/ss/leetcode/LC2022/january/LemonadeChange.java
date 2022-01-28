package com.ss.leetcode.LC2022.january;

public class LemonadeChange {
    // https://leetcode.com/problems/lemonade-change/
    public boolean lemonadeChange(int[] bills) {
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
