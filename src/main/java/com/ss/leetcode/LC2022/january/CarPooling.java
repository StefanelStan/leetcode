package com.ss.leetcode.LC2022.january;

public class CarPooling {
    // https://leetcode.com/problems/car-pooling/
    /** Algorithm:
     *  1. Map a table/timesheet for given trip time and its load. For each trip
     *     Increase the req capacity of startTime and decrease Capacity on endTime.
     *  2. Do a line sweep of the time array, from 1 to 1000, and calculate the required car capacity. If req > capacity, return false;
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] tripTimers = new int[1001];
        // On a time axis (0, 1000) mark/increase the StartTime with trip capacity and decrease EndTime with trip capacity.
        for(int[] trip : trips) {
            tripTimers[trip[1]] += trip[0];
            tripTimers[trip[2]] -= trip[0];
        }
        int tempCarCapacity = 0;
        // Do a line sweep and check if at any given time the req car capacity > car capacity.
        for(int tripTimer : tripTimers) {
            tempCarCapacity += tripTimer;
            if (tempCarCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
