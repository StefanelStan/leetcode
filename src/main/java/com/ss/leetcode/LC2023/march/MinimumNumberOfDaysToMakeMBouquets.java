package com.ss.leetcode.LC2023.march;

public class MinimumNumberOfDaysToMakeMBouquets {
    //https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
    /** Algorithm
        1. Fail fast: if (long)m * k > bloomday.length return -1 (not enough flowers)
        2. If m == 1 and k == 1 or k == n (1 bouquet of 1 flower or ALL flowers) return min day or max day
        3. The number of days is somewhere between firstDay (min) and lastDay(max).
            So you will have to binary search the answer. If you can gather in x days (pivot),
            can you gather in half x days? (left, right, pivot)
        4. Function to determine if you can gather in m bouquets in x (pivot)days: Sliding window technique
        5. Iterate over days
            - If current day <= pivot/given days, gather the flower (gatheredFlowers++).
              If gatheredFlowers == k, increment the bouquets. (gatheredBouquets++)
              If enough gatheredBouquets (gatheredBouquets == m), return true
            - If current day > given day/pivot, reset gatheredFlowers.
            - At the end, return gatheredBouquets >= m
        6. As in any binary search, when methods 4 and 5 finish (low <= high), return low.
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) {
            return -1;
        }
        int firstDay = Integer.MAX_VALUE, lastDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            firstDay = Math.min(firstDay, day);
            lastDay = Math.max(lastDay, day);
        }
        // instant response if 1 bouquet of size 1 or n
        if (m == 1) {
            if( k == 1){
                return firstDay;
            } else if (k == bloomDay.length) {
                return lastDay;
            }
        }
        int low = firstDay, high = lastDay;
        int pivot;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            if (canMakeBouquetsInDays(bloomDay, m, k, pivot)) {
                high = pivot -1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private boolean canMakeBouquetsInDays(int[] bloomDay, int m, int k, int days) {
        int bouquetsDone = 0;
        int gathered = 0;
        for (int i = 0; i < bloomDay.length && bouquetsDone <= m; i++) {
            if (bloomDay[i] <= days) {
                if(++gathered == k) {
                    gathered = 0;
                    bouquetsDone++;
                }
            } else {
                gathered = 0;
            }
        }
        return bouquetsDone >= m;
    }
}
