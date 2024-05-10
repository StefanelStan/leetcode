package com.ss.leetcode.LC2024.may;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    // https://leetcode.com/problems/k-th-smallest-prime-fraction
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> fractions = getFractions(arr, k);
        return new int[]{fractions.peek().up, fractions.peek().down};
    }

    private PriorityQueue<Fraction> getFractions(int[] arr, int k) {
        PriorityQueue<Fraction> fractions = new PriorityQueue<>(Comparator.comparingDouble(f -> f.value));
        int maxSize = 1 + (arr.length * (arr.length - 1)/ 2) - k;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                fractions.add(new Fraction((double)arr[i]/arr[j], arr[i], arr[j]));
                if (fractions.size() > maxSize) {
                    fractions.poll();
                }
            }
        }
        return fractions;
    }

    private static class Fraction {
        double value;
        int up;
        int down;

        public Fraction(double value, int up, int down) {
            this.value = value;
            this.up = up;
            this.down = down;
        }
    }
}
