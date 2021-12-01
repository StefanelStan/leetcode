package com.ss.leetcode.LC2021.april;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortIntegersByThePowerValue {
    // https://leetcode.com/problems/sort-integers-by-the-power-value/
    public int getKth(int lo, int hi, int k) {
        SortedSet<Pair> sortedPairs = new TreeSet<>();
        for (int i = lo; i <= hi; i++) {
            sortedPairs.add(new Pair(getPowerOf(i), i));
        }

        int start = 1;
        Iterator<Pair> it = sortedPairs.iterator();
        while (start < k) {
            it.next();
            start++;
        }
        return it.next().value;
    }

    private int getPowerOf(int i) {
        int steps = 0;
        while (i != 1) {
            if (i %2 == 0) {
                i = i / 2;
            } else {
                i = 3 * i + 1;
            }
            steps++;
        }
        return steps;
    }

    private static class Pair implements Comparable<Pair>{
        private final int powerValue;
        private final int value;

        public Pair(int powerValue, int value) {
            this.powerValue = powerValue;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            int firstCompare = Integer.compare(this.powerValue, o.powerValue);
            if (firstCompare == 0) {
                return Integer.compare(this.value, o.value);
            } else {
                return firstCompare;
            }
        }
    }
}
