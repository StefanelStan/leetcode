package com.ss.leetcode.LC2024.july;

public class PartitionArraySuchThatMaximumDifferenceIsK {
    // https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k
    /** Algorithm
        1. The numbers will be grouped in their ascending orders: [1,1,1,2], [4,4,4,4,4,5,5] etc
        2. Use a boolean[] present[100_001] and mark which numbers are present.
        3. Traverse present array and if current element is present and the diff between current and first in current window/seq > k,
            increment partitions and set new window/seq start
     */
    public int partitionArray(int[] nums, int k) {
        boolean[] present = new boolean[100_001];
        int min = Integer.MAX_VALUE, max = 0;
        for (int num : nums) {
            present[num] = true;
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int partitions = 1, first = min;
        for (int i = min; i <= max; i++) {
            if (present[i] && i - first > k) {
                partitions++;
                first = i;
            }
        }
        return partitions;
    }
}
