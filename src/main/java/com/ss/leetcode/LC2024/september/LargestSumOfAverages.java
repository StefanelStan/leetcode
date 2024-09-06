package com.ss.leetcode.LC2024.september;

public class LargestSumOfAverages {
    // https://leetcode.com/problems/largest-sum-of-averages
    public double largestSumOfAverages(int[] nums, int k) {
        Double[][][] partitions = new Double[nums.length][nums.length][k + 1];
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        return partition(nums, 0, 0, k, prefixSum, partitions);
    }

    private double partition(int[] nums, int index, int firstIndex, int remainingPartitions, int[] prefixSum, Double[][][] partitions) {
        if (index == nums.length) {
            if (firstIndex == nums.length) {
                return 0;
            } else {
                int leftSum = firstIndex == 0 ? 0 : prefixSum[firstIndex - 1];
                return ((double) (prefixSum[nums.length - 1] - leftSum)) / (nums.length - firstIndex);
            }
        }
        if (partitions[index][firstIndex][remainingPartitions] == null) {
            if (remainingPartitions == 1) {
                int left = index == 0 ? 0 : prefixSum[index - 1];
                partitions[index][firstIndex][remainingPartitions] = ((double)(prefixSum[nums.length - 1] - left)) / (nums.length - index);
            } else {
                int left = firstIndex == 0 ? 0 : prefixSum[firstIndex - 1];
                double avg = (double)(prefixSum[index] - left) / (1 + index - firstIndex);
                double nextPartitionAvg = partition(nums, index + 1, index + 1, remainingPartitions - 1, prefixSum, partitions);

                double continuePartition = partition(nums, index + 1, firstIndex, remainingPartitions, prefixSum, partitions);
                // continue this partition

                partitions[index][firstIndex][remainingPartitions] = Math.max(avg + nextPartitionAvg, continuePartition);
            }
        }
        return partitions[index][firstIndex][remainingPartitions];
    }
}
