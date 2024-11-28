package com.ss.leetcode.LC2024.november;

public class FindKthLargestXORCoordinateValue {
    // https://leetcode.com/problems/find-kth-largest-xor-coordinate-value
    /** Algorithm
        1. Use an int[2^20 - 1] to store a counting sort of all possible XORs. The max XOR for values of max 10^6 is 2^20 - 1. (20 1s).
        2. Perform a prefix XOR for the matrix and store the value in the counting array.
        3. Starting from highest entry in counting xor, traverse back, decrementing k, stopping when k reaches 0. Return the stopping position.
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int[] xorCount = getXorCount(matrix);
        return findKthLargestValue(xorCount, k);
    }

    private int[] getXorCount(int[][] matrix) {
        int[] xorCount =  new int[1_059_000];
        int[] topXor = new int[matrix[0].length];
        topXor[0] = matrix[0][0];
        xorCount[matrix[0][0]]++;
        int[] currentXorRow = new int[matrix[0].length];
        int currentXor = 0;
        for (int j = 1; j < topXor.length; j++) {
            topXor[j] = topXor[j-1] ^ matrix[0][j];
            xorCount[topXor[j]]++;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                currentXor = j == 0 ? matrix[i][j] : currentXor ^ matrix[i][j];
                currentXorRow[j] = currentXor ^ topXor[j];
                xorCount[currentXorRow[j]]++;
            }
            topXor = currentXorRow;
        }
        return xorCount;
    }

    private int findKthLargestValue(int[] xorCount, int k) {
        int step;
        for (int i = xorCount.length - 1; i >=0; i--) {
            step = Math.min(xorCount[i], k);
            xorCount[i] -= step;
            k -= step;
            if(k == 0) {
                return i;
            }
        }
        return -1;
    }
}
