package com.ss.leetcode.LC2023.july;

public class MinimumTimeToRepairCars {
    // https://leetcode.com/problems/minimum-time-to-repair-cars
    /** Algorithm
        1. Basic math: if a mechanic with rank r can repair n cars in r * n^2 minutes, how
            many cars (c) can he repair in T minutes?
            - c = Math.sqrt(T / r). c ^ 2 * r = T.
            EG: [7] and 10 cars. 7 * 100 = 700. He can repair 10 cars in 700 minutes. What about 300 minutes? 300 / 7 = 42.
            Sqrt(42) = 6.5 (so 6 cars)
        2. Applying this logic, we can find out if mechanics ran repair ALL the cars in given T minutes.
        3. For a given T number of minutes, find out how many cars can each mechanic repair.
            If the totalRepaired cars >= cars, then they can fix them all!
        4. Apply a binary search algorithm: if mechanics can repair ALL the cars in T minutes,
            increase T, else lower T.
            Your boundaries are between 1 and 10^14.
            Worst case scenario: 10^6 cars and 1 mechanic with rank 100: 100 * 10^12 = 10^14.
     */
    public long repairCars(int[] ranks, int cars) {
        long low = 0, high = 100000000000000L, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canRepairAllCars(ranks, cars, pivot)) {
                high = pivot -1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long totalMinutes) {
        int repairedCars = 0;
        for (int i = 0; i < ranks.length && repairedCars < cars; i++) {
            repairedCars += (int) Math.sqrt(totalMinutes / ranks[i]);
        }
        return repairedCars >= cars;
    }
}
