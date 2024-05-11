package com.ss.leetcode.LC2024.may;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
    // https://leetcode.com/problems/minimum-cost-to-hire-k-workers
    // TODO
    public double mincostToHireWorkers2(int[] quality, int[] wage, int k) {
        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;
        List<WageQualityRatio> ratioList = new ArrayList<>(quality.length);
        for (int i = 0; i < quality.length; i++) {
            ratioList.add(new WageQualityRatio((double) wage[i] / quality[i], quality[i]));
        }
        Collections.sort(ratioList, Comparator.comparingDouble(r -> r.ratio));
        PriorityQueue<Integer> qualityWorkers = new PriorityQueue<>(Comparator.reverseOrder());
        for (WageQualityRatio ratioItem : ratioList) {
            qualityWorkers.add(ratioItem.quality);
            currentTotalQuality += ratioItem.quality;
            if (qualityWorkers.size() > k) {
                currentTotalQuality -= qualityWorkers.poll();
            }

            if (qualityWorkers.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality * ratioItem.ratio);
            }
        }
        return totalCost;
    }

    private static class WageQualityRatio {
        double ratio;
        int quality;

        public WageQualityRatio(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }
}
