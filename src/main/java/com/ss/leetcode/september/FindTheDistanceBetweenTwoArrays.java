package com.ss.leetcode.september;

public class FindTheDistanceBetweenTwoArrays {
    // https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        boolean[] arr2Shift = new boolean[2001];
        for (int num : arr2) {
            arr2Shift[num + 1000] = true;
        }
        int distance = 0;
        for (int num : arr1) {
            int upperLimit = Math.min(num + d + 1000, 2000);
            int lowerLimit = Math.max(num - d + 1000, 0);
            boolean containsBadInterval = false;
            for (int i = lowerLimit; i <= upperLimit; i++) {
                if (arr2Shift[i]) {
                    containsBadInterval = true;
                    break;
                }
            }
            if (!containsBadInterval) {
                distance++;
            }
        }
        return distance;
    }
}
