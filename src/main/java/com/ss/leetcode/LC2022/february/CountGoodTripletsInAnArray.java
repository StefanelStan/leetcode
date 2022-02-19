package com.ss.leetcode.LC2022.february;

import java.util.Arrays;

public class CountGoodTripletsInAnArray {
    // https://leetcode.com/contest/biweekly-contest-72/problems/count-good-triplets-in-an-array/
    // TLE
    public long goodTriplets(int[] nums1, int[] nums2) {
        if (nums1.length == 3) {
            return Arrays.equals(nums1, nums2) ? 1 : 0;
        }

        int goodTriples = 0;
        int[] nums1Positions = new int[nums1.length];
        int[] nums2Positions = new int[nums2.length];
        countPositions(nums1, nums1Positions, nums2, nums2Positions);
        for (int i = 0; i < nums1.length -2; i++) {
            for (int j = i; j < nums1.length -1; j++) {
                if (nums2Positions[nums1[j]] > nums2Positions[nums1[i]]) {
                    if (nums2Positions[nums1[j]] < j) {
                        goodTriples += countGoodTriples(nums1, j, nums2Positions[nums1[j]], nums2Positions);
                    } else {
                        goodTriples += countGoodTriples(nums2, nums2Positions[nums1[j]], j, nums1Positions);
                    }
                }
            }
        }

        return goodTriples;
    }

    private int countGoodTriples(int[] source, int sourceStart, int targetStart, int[] targetPos) {
        int goodTriples = 0;
        for (int i = sourceStart +1; i < source.length; i++) {
            if (targetPos[source[i]] > targetStart) {
                goodTriples++;
            }
        }
        return goodTriples;
    }

    private void countPositions(int[] nums1, int[] nums1Positions, int[] nums2, int[] nums2Positions) {
        for (int i = 0; i < nums1.length; i++) {
            nums1Positions[nums1[i]] = i;
            nums2Positions[nums2[i]] = i;
        }
    }
}
