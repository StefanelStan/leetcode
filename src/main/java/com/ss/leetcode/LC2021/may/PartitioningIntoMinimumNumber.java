package com.ss.leetcode.LC2021.may;

public class PartitioningIntoMinimumNumber {
    // https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
    public int minPartitions(String n) {
        char partitions = '0';
        for (char c : n.toCharArray()) {
            if (partitions < c) {
                partitions = c;
                if (partitions == '9') {
                    break;
                }
            }
        }
        return Integer.parseInt(String.valueOf(partitions));
    }

    public int minPartitions2(String n) {
        int partitions = 0;
        int currentValue;
        for (char c : n.toCharArray()) {
            currentValue = c - '0';
            if (currentValue > partitions) {
                partitions = currentValue;
                if (partitions == 9) {
                    return partitions;
                }
            }
        }
        return partitions;
    }
}
