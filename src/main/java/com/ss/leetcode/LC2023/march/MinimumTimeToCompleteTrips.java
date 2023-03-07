package com.ss.leetcode.LC2023.march;

public class MinimumTimeToCompleteTrips {
    // https://leetcode.com/problems/minimum-time-to-complete-trips
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
        }
        long low = 1, high = (long) totalTrips * maxTime;
        long pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canCompleteTripsInTime(time, pivot, totalTrips)) {
                high = pivot -1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private boolean canCompleteTripsInTime(int[] time, long pivot, long remainingTrips) {
        long completedSoFar = 0L;
        for (int t : time) {
            completedSoFar += pivot / t;
        }
        return completedSoFar >= remainingTrips;
    }
}
