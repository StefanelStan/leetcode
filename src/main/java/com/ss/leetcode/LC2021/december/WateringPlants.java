package com.ss.leetcode.LC2021.december;

public class WateringPlants {
    // https://leetcode.com/problems/watering-plants/
    public int wateringPlants(int[] plants, int capacity) {
        int totalSteps = 0;
        int tempCapacity = capacity;
        for (int i = 0; i < plants.length;) {
            if (tempCapacity >= plants[i]) {
                totalSteps++;
                tempCapacity -= plants[i];
                i++;
            } else {
                tempCapacity = capacity;
                totalSteps += i * 2;
            }
        }
        return totalSteps;
    }
}
