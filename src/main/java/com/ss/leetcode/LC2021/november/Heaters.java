package com.ss.leetcode.LC2021.november;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class Heaters {
    // https://leetcode.com/problems/heaters/
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxRadius = 0;
        for (int hoIndex = 0, heIndex = 0; hoIndex < houses.length; hoIndex++) {
            heIndex = getClosestHeater(houses[hoIndex], heIndex, heaters);
            maxRadius = Math.max(maxRadius, Math.abs(houses[hoIndex] - heaters[heIndex]));
        }
        return maxRadius;
    }

    private int getClosestHeater(int house, int heIndex, int[] heaters) {
        int currentDistance = Math.abs(house - heaters[heIndex]), nextDistance;

        while(heIndex < heaters.length -1) {
            nextDistance = Math.abs(house - heaters[Math.min(heIndex + 1, heaters.length -1)]);
            if (currentDistance >= nextDistance) {
                currentDistance = nextDistance;
                heIndex++;
            } else {
                return heIndex;
            }
        }
        return heaters.length -1;
    }

      public int findRadius2(int[] houses, int[] heaters) {
        // sort houses and headers;
        // traverse each house and see which heater will be closest to it. Connect it and remember the max distance.
        // at the last house, return the max distance
        Arrays.sort(houses);
        TreeSet<Integer> heatersSet = new TreeSet<>();
        for (int heater : heaters) {
            heatersSet.add(heater);
        }
        int maxRadius = 0;
        Integer floorHeater, ceilingHeater;
        for (int house : houses) {
            floorHeater = heatersSet.floor(house);
            ceilingHeater = heatersSet.ceiling(house);
            maxRadius = Math.max(maxRadius, getClosestHeater(house, floorHeater, ceilingHeater));
        }
        return maxRadius;
    }

    private int getClosestHeater(int houseNo, Integer a, Integer b) {
        if (a == null) {
            return Math.abs(houseNo - b);
        } else if (b == null) {
            return Math.abs(houseNo - a);
        } else {
            return Math.min(Math.abs(houseNo - a), Math.abs(houseNo - b));
        }
    }
}
