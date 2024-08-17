package com.ss.leetcode.LC2024.august;

public class MaximumNumberOfPointsWithCost {
    // https://leetcode.com/problems/maximum-number-of-points-with-cost
    /** Algorithm
        1. For a row[i][j] you need to know the best column to pick from the row beneath.
        2. You can loop the row[i+1] in order to determine the best column to pick for row[i][j]. However, you will need to to this for
            all columns in row[i].
        3. What if you could compute the maxGain of row[i+1] and cache it?
            - Same as house robber, if you need to decide if you want to gain the bonus from left but deduct 1 or pick current column and gain its bonus.
            - Use two long[] to traverse the next row with 2 indices (i = 1, j = m-2) and set the maxGain from left and maxGain from right.
            - maxGainOnLeft[j] = max(maxGainOnLeft[j-1] - 1, beneathRowBestChoice[j]).
            - Use double house robber but one for left best gain and one for right best gain.
        4. Calculating this, for each row[i][j] you can know that its best outcome will come from max(maxOnLeft[j], maxOnRight[j]).
        5. Return the max gain of the top row.
     */
    public long maxPoints(int[][] points) {
        long[] maxGain =  new long[points[0].length];
        for (int j = 0; j < points[0].length; j++) {
            maxGain[j] = points[points.length - 1][j];
        }
        return computeMaxGain(maxGain, points);
    }

    private long computeMaxGain(long[] rowMaxGain, int[][] points) {
        int n = points.length, m = points[0].length;
        long[] maxOnLeft = new long[m];
        long[] maxOnRight = new long[m];
        long[] newRowGain = new long[m];
        for (int row = n - 2; row >= 0; row--) {
            maxOnLeft[0] = rowMaxGain[0];
            maxOnRight[m - 1] = rowMaxGain[m - 1];
            for (int i = 1, j = m - 2; i < m; i++, j--) {
                maxOnLeft[i] = Math.max(maxOnLeft[i - 1] - 1, rowMaxGain[i]);
                maxOnRight[j] = Math.max(maxOnRight[j + 1] - 1, rowMaxGain[j]);
            }
            for (int j = 0; j < m; j++) {
                newRowGain[j] = points[row][j] + Math.max(maxOnLeft[j], maxOnRight[j]);
            }
            rowMaxGain = newRowGain;
        }
        long max = 0L;
        for (long gain : rowMaxGain) {
            max = Math.max(max, gain);
        }
        return max;
    }

    // N * M matrix to store the whole result stack
    public long maxPoints2(int[][] points) {
        long[][] maxGain =  new long[points.length][points[0].length];
        for (int j = 0; j < maxGain[0].length; j++) {
            maxGain[points.length - 1][j] = points[points.length - 1][j];
        }
        return computeMaxGain(maxGain, points);
    }

    private long computeMaxGain(long[][] maxGain, int[][] points) {
        long[] maxOnLeft = new long[maxGain[0].length];
        long[] maxOnRight = new long[maxOnLeft.length];
        for (int i = maxGain.length - 2; i >= 0; i--) {
            calculateRowMaxGain(maxGain, i, points, maxOnLeft, maxOnRight);
        }
        long max = 0L;
        for (long gain : maxGain[0]) {
            max = Math.max(max, gain);
        }
        return max;
    }

    private void calculateRowMaxGain(long[][] maxGain, int row, int[][] points, long[] maxOnLeft, long[] maxOnRight) {
        maxOnLeft[0] = maxGain[row + 1][0];
        maxOnRight[maxOnRight.length - 1] = maxGain[row + 1][maxOnRight.length - 1];
        for (int i = 1, j = maxOnRight.length - 2; i < maxOnRight.length; i++, j--) {
            maxOnLeft[i] = Math.max(maxOnLeft[i - 1] - 1, maxGain[row + 1][i]);
            maxOnRight[j] = Math.max(maxOnRight[j + 1] - 1, maxGain[row + 1][j]);
        }
        for (int j = 0; j < maxOnLeft.length; j++) {
            maxGain[row][j] = points[row][j] + Math.max(maxOnLeft[j], maxOnRight[j]);
        }
    }
}
