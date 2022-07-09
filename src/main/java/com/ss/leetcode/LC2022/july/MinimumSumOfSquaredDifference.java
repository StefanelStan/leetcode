package com.ss.leetcode.LC2022.july;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MinimumSumOfSquaredDifference {
    // https://leetcode.com/contest/biweekly-contest-82/problems/minimum-sum-of-squared-difference/
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long minSumSquare = 0;
        int[] diffs = new int[100_001];
        long totalDiff = 0;
        long kSum = k1 + k2;
        int currentDiff;
        int maxDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            currentDiff = Math.abs(nums1[i] - nums2[i]);
            if (currentDiff > 0) {
                totalDiff += currentDiff;
                diffs[currentDiff]++;
                maxDiff = Math.max(maxDiff, currentDiff);
            }
        }
        if (totalDiff <= kSum) {
            return 0;
        }
        for (int i = maxDiff; i> 0 && kSum > 0; i--) {
            if (diffs[i] > 0) {
                if (diffs[i] >= kSum) {
                    diffs[i] -= kSum;
                    diffs[i-1] += kSum;
                    kSum = 0;
                } else {
                    diffs[i-1] += diffs[i];
                    kSum -= diffs[i];
                    diffs[i] = 0;
                }
            }
        }

        for (int i = 0; i <= maxDiff; i++) {
            if (diffs[i] > 0) {
                minSumSquare += (long) (Math.pow((long)i, 2)) * diffs[i];
            }
        }
        return minSumSquare;
    }


    public long minSumSquareDiff2(int[] nums1, int[] nums2, int k1, int k2) {
        TreeMap<Integer, Integer> diffMap = new TreeMap<>(Comparator.reverseOrder());
        long totalDiff = 0;
        int kSum = k1 + k2;
        int diff = 0;
        for (int i = 0; i < nums1.length; i++) {
            diff = Math.abs(nums1[i] - nums2[i]);
            totalDiff += diff;
            if (diff > 0) {
                diffMap.merge(diff, 1, Integer::sum);
            }
        }
        if (totalDiff <= kSum) {
            return 0;
        }

        while (kSum > 0) {
            Map.Entry<Integer, Integer> entry = diffMap.ceilingEntry(Integer.MAX_VALUE);
            int val = entry.getKey();
            int count = entry.getValue();
            if (count <= kSum) {
                kSum -= count;
                diffMap.merge(val - 1, count, Integer::sum);
                diffMap.remove(val);
            } else {
                diffMap.merge(val - 1, kSum, Integer::sum);
                diffMap.put(val, count - kSum);
                kSum = 0;
            }
        }

        long result = 0;
        for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
            result += entry.getValue() * (long)(Math.pow(entry.getKey(), 2));
        }
        return result;
    }
}
