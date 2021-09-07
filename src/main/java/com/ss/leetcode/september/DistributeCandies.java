package com.ss.leetcode.september;

public class DistributeCandies {
    // https://leetcode.com/problems/distribute-candies/
    public int distributeCandies(int[] candyType) {
        boolean[] present = new boolean[200_001];
        int types = 0, index = 0;
        for (int candy : candyType) {
            index = candy + 100_000;
            if (!present[index]) {
                present[index] = true;
                types++;
            }
        }
        return Math.min(candyType.length/2, types);
    }
}
