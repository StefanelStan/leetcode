package com.ss.leetcode.LC2023.may;

import java.util.TreeSet;

public class MinimumCostToCutAStick {
    // Needs fixing
    public int minCost(int n, int[] cuts) {
        TreeSet<Integer> sortedCuts = getSortedCuts(cuts);
        return cutStick(0, n, sortedCuts);
    }

    private int cutStick(int start, int end, TreeSet<Integer> sortedCuts) {
        if (end - start == 1 || sortedCuts.isEmpty()) {
            return 0;
        }
        int cost = 0;
        int middle = start + (end-start) / 2;
        Integer upperCut = sortedCuts.ceiling(middle);
        Integer lowerCut = sortedCuts.floor(middle);
        int bestCut = findBestCut(start, end, middle, upperCut, lowerCut);
        if (bestCut != -1) {
            cost += (end - start);
            sortedCuts.remove(bestCut);
            cost += cutStick(start, bestCut, sortedCuts);
            cost += cutStick(bestCut, end, sortedCuts);

        }
        return cost;
    }

    private int findBestCut(int start, int end, int middle, Integer upperCut, Integer lowerCut) {
        if (upperCut == null || upperCut > end) {
            if (lowerCut == null || lowerCut < start) {
                return -1;
            } else {
                return lowerCut;
            }
        } else if (lowerCut == null || lowerCut < start){
            return upperCut;
        } else {
            return upperCut - middle < middle - lowerCut ? upperCut : lowerCut;
        }
    }

    private TreeSet<Integer> getSortedCuts(int[] cuts) {
        TreeSet<Integer> sortedCuts = new TreeSet<>();
        for (int cut : cuts) {
            sortedCuts.add(cut);
        }
        return sortedCuts;
    }
}
