package com.ss.leetcode.LC2021.july;

public class TotalHammingDistance {
    // https://leetcode.com/problems/total-hamming-distance/
    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        int[] onePositions = new int[32];
        int maxLength = countOnePositions(nums, onePositions);

        for (int k = 0; k < maxLength; k++) {
            totalDistance += onePositions[k] * (nums.length - onePositions[k]);
        }
        return totalDistance;
    }

    private int countOnePositions(int[] nums, int[] onePositions) {
        int maxLength = 0;
        String binary;
        for (int num : nums) {
            binary = Integer.toBinaryString(num);
            if (binary.length() > maxLength) {
                maxLength = binary.length();
            }
            for (int j = binary.length() - 1, k = 0; j >= 0; j--, k++) {
                if (binary.charAt(j) == '1') {
                    onePositions[k] = onePositions[k] + 1;
                }
            }
        }
        return maxLength;
    }
}
