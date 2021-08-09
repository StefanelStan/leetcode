package com.ss.leetcode.august;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    // https://leetcode.com/problems/maximum-units-on-a-truck/
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // ordee the boxes by their maximum size/capacity. We want them first
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
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
