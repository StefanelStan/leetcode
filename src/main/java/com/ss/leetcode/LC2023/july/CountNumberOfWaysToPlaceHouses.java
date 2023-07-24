package com.ss.leetcode.LC2023.july;

public class CountNumberOfWaysToPlaceHouses {
    // https://leetcode.com/problems/count-number-of-ways-to-place-houses
    public int countHousePlacements(int n) {
        int first = 1, second = 1;
        while (n-- > 0) {
            second = (first + second) % 1_000_000_007;
            first = second - first;
        }
        return (int) (((long) second * second) % 1_000_000_007);
    }
}
