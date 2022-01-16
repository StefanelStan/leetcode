package com.ss.leetcode.LC2022.january;

public class MaximizeDistanceToClosestPerson {
    // https://leetcode.com/problems/maximize-distance-to-closest-person/
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int tempDistance = 0;
        for (int seat : seats) {
            if (seat == 0) {
                tempDistance++;
                maxDistance = Math.max(maxDistance, tempDistance);
            } else {
                tempDistance = 0;
            }
        }
        int leftZeroes = 0, rightZeroes = 0;
        for (int seat : seats) {
            if (seat == 0) {
                leftZeroes++;
            } else {
                break;
            }
        }
        for (int i = seats.length -1; i >= 0; i--) {
            if (seats[i] == 0) {
                rightZeroes++;
            } else {
                break;
            }
        }
        return Math.max((maxDistance + 1) /2, Math.max(leftZeroes, rightZeroes));
    }
}
