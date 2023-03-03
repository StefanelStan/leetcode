package com.ss.leetcode.LC2023.march;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumAmountOfTimeToFillCups {
    // https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> cups = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for(int a : amount) {
            if (a > 0) {
                cups.add(a);
            }
        }
        int first, second;
        while(cups.size() > 1) {
            first = cups.poll() - 1;
            second = cups.poll() - 1;
            time++;
            if (first > 0) {
                cups.add(first);
            }
            if (second > 0) {
                cups.add(second);
            }
        }
        return time + (cups.size() > 0 ? cups.peek() : 0);
    }
}
