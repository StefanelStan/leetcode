package com.ss.leetcode.LC2024.january;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    // https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
    /** Algorithm
        1. Calculate prefix sum (2D prefix sum of the matrix)
        2. Fail fast: if min > threshold, return 0 as you can even get a square of 1 with that threshold
        3. For each [i,j] try to expand in a square ([i,j] top left [i+x,j+x] bottom right)and search for "good" square matrix sum.
        4. Do not expand iteratively [i+1,j+2], [i+2, j+2].. but in a binary search
            low = index / sum(i,j, i+maxEdgeSoFar, j+maxEdge) high = index / sum(i,j, i+limitLength, j+limitLength).
            if sum(pivot_matrix) <= threshold, increase low, else decrease high
        5. If you have already a maxEdge, then each "search" starts from that index as low (don't need to start i+0,j+0 as low).
        6. Use smart stoppers. Do not advance i/j further if i+maxEdge/j+maxEdge would go over the limit of matrix.
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int[] min = {mat[0][0]};
        int[][] prefixSum = calculatePrefix(mat, min);
        if (min[0] > threshold) {
            return 0;
        }
        int maxEdge = 1, minWidthHeight = Math.min(mat.length, mat[0].length);
        for (int i = 0; i < mat.length - 1 && maxEdge < minWidthHeight && i + maxEdge < mat.length; i++) {
            for (int j = 0; j < mat[i].length -1 && maxEdge < minWidthHeight && j + maxEdge < mat[0].length; j++) {
                maxEdge = Math.max(maxEdge, findEdge(i, j, maxEdge, prefixSum, threshold));
            }
        }
        return maxEdge;
    }

    private int findEdge(int i, int j, int minOffset, int[][] prefixSum, int threshold) {
        int low = minOffset, high = Math.min(prefixSum.length - i, prefixSum[0].length - j) - 1;
        int pivot = 0, pivotSum;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            pivotSum = getSquareSum(i, j, i + pivot, j + pivot, prefixSum);
            if (pivotSum <= threshold) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low;
    }

    private int getSquareSum(int upX, int upY, int lowX, int lowY, int[][] prefixSum) {
        int onLeft = upY == 0 ? 0 : prefixSum[lowX][upY-1];
        int onTop = upX == 0 ? 0 : prefixSum[upX-1][lowY];
        int overlapping = (upX == 0 || upY == 0 ? 0 : prefixSum[upX - 1][upY - 1]);
        return prefixSum[lowX][lowY] - (onLeft + onTop - overlapping);
    }

    private int[][] calculatePrefix(int[][] mat, int[] min) {
        int[][] prefixSum = new int[mat.length][mat[0].length];
        int rowSum, up;
        for (int i = 0; i < mat.length; i++) {
            rowSum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                rowSum += mat[i][j];
                up = i == 0 ? 0 : prefixSum[i-1][j];
                prefixSum[i][j] = up + rowSum;
                min[0] = Math.min(min[0], mat[i][j]);
            }
        }
        return prefixSum;
    }
}
