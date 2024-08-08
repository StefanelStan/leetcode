package com.ss.leetcode.LC2024.august;

public class SpiralMatrixIII {
    // https://leetcode.com/problems/spiral-matrix-iii
    /** Algorithm
        1. Simulate the movement from current position to EAST, SOUTH, WEST, NORTH
        2. Moving actually means advancing based on a set of coefficient: NORTH means i-- while WEST means j--. South is i++
        3. Move in a spiral based on startX,startY, endX, endY.
        4. Moving east means your endX = startX + radius + 1. (without the last index)
        5. Each time you move south or north your radius increases.
     */
    private static final int[][] coordIndices = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int EAST = 0, SOUTH = 1, WEST = 2, NORTH = 3;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows * cols][2];
        int[] insertIndex = {0};
        int currentDirection = EAST;
        int radius = 1;
        int xStop, yStop;
        while (insertIndex[0] < matrix.length) {
            switch(currentDirection) {
                case EAST -> {
                    xStop = rStart;
                    yStop = cStart + radius + 1;
                    travelAndInsert(rStart, cStart, xStop, yStop, currentDirection, rows, cols, matrix, insertIndex);
                    rStart = xStop + 1;
                    cStart = yStop - 1;
                }
                case SOUTH -> {
                    xStop = (rStart + radius) - 1;
                    yStop = cStart;
                    travelAndInsert(rStart, cStart, xStop, yStop, currentDirection, rows, cols, matrix, insertIndex);
                    radius++;
                    rStart = xStop;
                    cStart = yStop;
                }
                case WEST -> {
                    xStop = rStart;
                    yStop = (cStart - radius) - 1;
                    travelAndInsert(rStart, cStart, xStop, yStop, currentDirection, rows, cols, matrix, insertIndex);
                    rStart = xStop - 1;
                    cStart = yStop + 1;
                }
                case NORTH -> {
                    xStop = (rStart - radius) + 1;
                    yStop = cStart;
                    travelAndInsert(rStart, cStart, xStop, yStop, currentDirection, rows, cols, matrix, insertIndex);
                    radius++;
                    rStart = xStop;
                    cStart = yStop;
                }
            }
            currentDirection = (currentDirection + 1) % 4;
        }
        return matrix;
    }

    private void travelAndInsert(int xFrom, int yFrom, int xStop, int yStop, int direction, int maxRows, int maxCols, int[][] matrix, int[] insertIndex) {
        while (!(xFrom == xStop && yFrom == yStop)) {
            if (xFrom >= 0 && xFrom < maxRows && yFrom >= 0 && yFrom < maxCols) {
                matrix[insertIndex[0]++] = new int[]{xFrom, yFrom};
            }
            xFrom += coordIndices[direction][0];
            yFrom += coordIndices[direction][1];
        }
    }
}
