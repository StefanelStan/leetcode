package com.ss.leetcode.LC2021.august;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
    // https://leetcode.com/problems/maximum-units-on-a-truck/
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int maxUnits = 0;
        int stepUnits = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            stepUnits = Math.min(boxTypes[i][0], truckSize);
            maxUnits += (stepUnits * boxTypes[i][1]);
            truckSize -= stepUnits;
        }
        return maxUnits;
    }





    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        // order the boxes by their maximum size/capacity. We want them first
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[0]));
        int remainingTruckCapacity = truckSize;
        int maxUnits = 0;
        // If truck is not full, load boxes, starting with the biggest ones first
        for(int[] box : boxTypes) {
            if (remainingTruckCapacity == 0) {
                break;
            }
            // if can't add all boxes from current stack only add as many till truck is full
            if (box[0] > remainingTruckCapacity) {
                maxUnits += remainingTruckCapacity * box[1];
                remainingTruckCapacity = 0;
            } else {
                maxUnits += box[0] * box[1];
                remainingTruckCapacity -= box[0];
            }
        }
        return maxUnits;
    }
}
