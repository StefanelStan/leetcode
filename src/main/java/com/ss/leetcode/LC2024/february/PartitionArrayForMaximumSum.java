package com.ss.leetcode.LC2024.february;

public class PartitionArrayForMaximumSum {
    // https://leetcode.com/problems/partition-array-for-maximum-sum
    /** Algorithm
        1. Standard DP: pick current element, break the partition and look for new on the right OR pick current and continue partitioning
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return partitionArray(0, 0, 0, arr, k, new Integer[arr.length][]);
    }

    private int partitionArray(int index, int taken, int maxOnTaken, int[] arr, int k, Integer[][] bestPartitions) {
        if (index == arr.length) {
            return taken * maxOnTaken;
        }
        if (bestPartitions[index] == null) {
            bestPartitions[index] = new Integer[k+1];
        }
        if (bestPartitions[index][taken] == null) {
            maxOnTaken = Math.max(maxOnTaken, arr[index]);
            // pick current and break
            bestPartitions[index][taken] = (taken + 1) * maxOnTaken + partitionArray(index + 1, 0, 0, arr, k, bestPartitions);
            // pick current and continue
            if (taken + 1 < k) {
                bestPartitions[index][taken] = Math.max(
                    bestPartitions[index][taken],
                    partitionArray(index + 1, taken + 1, maxOnTaken, arr, k, bestPartitions));
            }
        }
        return bestPartitions[index][taken];
    }
}
