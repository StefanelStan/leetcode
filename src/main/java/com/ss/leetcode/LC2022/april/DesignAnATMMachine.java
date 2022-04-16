package com.ss.leetcode.LC2022.april;

import java.util.Arrays;

public class DesignAnATMMachine {
    // https://leetcode.com/contest/biweekly-contest-76/problems/design-an-atm-machine/
    private final long[] notes;
    private final int[] values = {20, 50, 100, 200, 500};
    long sum = 0;
    public DesignAnATMMachine() {
         notes = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        sum = 0;
        for(int i = 0; i < banknotesCount.length; i++) {
            notes[i] += banknotesCount[i];
            sum += ((long) notes[i] * values[i]);
        }
    }

    public int[] withdraw(int amount) {
        if (sum < amount) {
            return new int[]{-1};
        }
        int[] response = new int[5];
        long[] valuesCopy = Arrays.copyOf(notes, 5);
        for (int i = 4; i >= 0 && amount > 0; i--) {
            if (amount >= values[i] && notes[i] > 0) {
                long maxBills = Math.min(notes[i], amount / values[i]);
                amount -= (maxBills * values[i]);
                notes[i] -= maxBills;
                response[i] = (int) maxBills;
            }
        }
        if (amount > 0) {
            System.arraycopy(valuesCopy, 0, notes, 0, notes.length);
            return new int[]{-1};
        }
       return response;
    }
}
