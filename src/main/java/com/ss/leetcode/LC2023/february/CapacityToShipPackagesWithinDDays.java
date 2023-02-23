package com.ss.leetcode.LC2023.february;

public class CapacityToShipPackagesWithinDDays {
    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
    /** Algorithm
        1. Fail fast: if days == 1, then return the total weight
        2. No matter the given number of days, the min ship capacity must be >= heaviest package AND
            the total weights.
        3. How many days will you need if you select heavyest package as ship capacity?
            How many days will you need if you select heavyest package * 2?
        4. Looking at #3 and #4, you realize that your answer is somewhere in between[biggestW, totalW]
        5. How to find it? binary search:
            - eg: [1,2,3,4,5,6,7,8,9,10], days = 5 . heaviest = 10, total = 55.
            - pick 32 as middle. Can you ship in 5 days with 32 ship capacity? yes. (you can ship in 2 days) -> need lesser capacity
            - pick 20 as middle. (10 + (31-10)/ 2). With 20 capacity you can ship in 4 days. Need lesser capacity
            - pick 14 as middle (10 + (19-10)/2). With 14 capacity you need 6 days. So we need bigger capacity
            - pick 17 as middle (15 + (19-15)/2). With 17 you need 5 days. But is it optimal? Try with less
            - pick pick 15 (15 + (16-15)/2). You can deliver within 5 days. Can we do better?
             now higher/right pointer becomes 15-1 = 14. As left(15) > right(14), we break the binary search.
        6. Return left;
     */
    public int shipWithinDays(int[] weights, int days) {
        int[] maxAndTotal = getMaxAndTotal(weights);
        if (days == 1) {
            return maxAndTotal[1];
        }
        int left = maxAndTotal[0], right = maxAndTotal[1];
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (canShipInDays(weights, pivot, days)) {
                right = pivot -1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    private boolean canShipInDays(int[] weights, int maxWeight, int days) {
        int temp = 0, neededDays = 1;
        for (int i = 0; i < weights.length && neededDays <= days; i++) {
            temp += weights[i];
            if (temp > maxWeight) {
                temp = weights[i];
                neededDays++;
            }
        }
        return neededDays <= days;

    }

    private int[] getMaxAndTotal(int[] weights) {
        int max = 0;
        int total = 0;
        for(int w : weights) {
            max = Math.max(w, max);
            total += w;
        }
        return new int[]{max, total};
    }
}
