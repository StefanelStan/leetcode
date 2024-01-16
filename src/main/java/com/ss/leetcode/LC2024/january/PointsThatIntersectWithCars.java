package com.ss.leetcode.LC2024.january;

import java.util.List;

public class PointsThatIntersectWithCars {
    // https://leetcode.com/problems/points-that-intersect-with-cars
    /** Algorithm
        1. Use an int[102] parkedCars to mark each car's start/end
            - parkedCars[car.start]++
            - parkedCars[car.end + 1]--;
        2. For a car[3,5] the parkedCars would look like [0,0,0,1,0,0,-1,0,0]
        3. Mark each car in this array
        4. Traverse the parkedCars and do a prefixSum.
            - For each index, if the prefixSum > 0, that point is covered.
     */
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] parkedCars = getParkedCars(nums);
        int points = 0, coverage = 0;
        for (int i = 1; i <= 100; i++) {
            coverage += parkedCars[i];
            if (coverage > 0) {
                points++;
            }
        }
        return points;
    }

    private int[] getParkedCars(List<List<Integer>> cars) {
        int[] parkedCars = new int[102];
        for (List<Integer> car : cars) {
            parkedCars[car.get(0)]++;
            parkedCars[car.get(1) + 1]--;
        }
        return parkedCars;
    }
}
