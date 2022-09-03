package com.ss.leetcode.LC2022.september;

import java.util.PriorityQueue;

public class MaximumNumberOfRobotsWithinBudget {
    // https://leetcode.com/problems/maximum-number-of-robots-within-budget/
    // HARD
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int maxRobots = 0;
        PriorityQueue<int[]> maxCharges = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        maxCharges.add(new int[]{chargeTimes[0], 0});
        long totalCost = chargeTimes[0] + runningCosts[0];
        int left = 0, right = 0;
        long sumSoFar = runningCosts[0];
        while(right < chargeTimes.length) {
            // shrink the window on the left side
            if (totalCost > budget) {
                left++;
                if (left >= chargeTimes.length) {
                    break;
                }
                maxCharges.add(new int[]{chargeTimes[left], left});
                int maxCharge = getAndPurgeMaxCharges(maxCharges, left);
                if (right < left) { // you are on a new position and have to calculate the new budget.
                    right = left;
                    sumSoFar = runningCosts[left];
                } else {
                    sumSoFar -= runningCosts[left - 1];
                }
                totalCost = maxCharge + (long)((right - left) + 1) * sumSoFar;
                if (totalCost <= budget) {
                    maxRobots = Math.max(maxRobots, (right - left) + 1);
                }
            } else {
                //expand window and determine the new max if possible
                maxRobots = Math.max(maxRobots, (right - left) + 1);
                if (right < chargeTimes.length - 1) {
                    right++;
                    sumSoFar += runningCosts[right];
                    maxCharges.add(new int[]{chargeTimes[right], right});
                    int maxCharge = getAndPurgeMaxCharges(maxCharges, left);
                    totalCost = maxCharge + (long)((right - left) + 1) * sumSoFar;
                    if (totalCost <= budget) {
                        maxRobots = Math.max(maxRobots, (right - left) + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return maxRobots;
    }

    private int getAndPurgeMaxCharges(PriorityQueue<int[]> maxCharges, int left) {
        // this will always have 1 element that is at least equal to left index.
        while (!maxCharges.isEmpty() && maxCharges.peek()[1] < left) {
            maxCharges.poll();
        }
        return maxCharges.isEmpty()? -1 :  maxCharges.peek()[0];
    }
}
