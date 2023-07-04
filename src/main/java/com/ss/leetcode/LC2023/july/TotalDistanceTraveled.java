package com.ss.leetcode.LC2023.july;

public class TotalDistanceTraveled {
    // https://leetcode.com/problems/total-distance-traveled
    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0, usages = 0;
        while(mainTank > 0) {
            mainTank--;
            distance += 10;
            usages++;
            if (usages == 5 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
                usages = 0;
            }
        }
        return distance;
    }
}
