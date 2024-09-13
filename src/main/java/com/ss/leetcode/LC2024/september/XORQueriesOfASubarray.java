package com.ss.leetcode.LC2024.september;

public class XORQueriesOfASubarray {
    // https://leetcode.com/problems/xor-queries-of-a-subarray
    /** Algorithm
        1. In the case of prefixSum (and range sum interval), the interval sum would be prefixSum[right] - prefixSum[left - 1].
        2.In the case of XOR, the xor of [left, right] is prefixXor[right] ^ prefixXor[left - 1], same as prefix sum.
        3. Compute the prefixXor (rolling xor) and apply xor[right] ^ xor[left - 1].
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorResult = new int[arr.length];
        xorResult[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xorResult[i] = xorResult[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                result[i] = xorResult[queries[i][1]];
            } else {
                result[i] = xorResult[queries[i][1]] ^ xorResult[queries[i][0] - 1];
            }
        }
        return result;
    }
}
