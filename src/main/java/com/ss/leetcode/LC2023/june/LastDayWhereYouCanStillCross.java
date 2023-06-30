package com.ss.leetcode.LC2023.june;

public class LastDayWhereYouCanStillCross {
    // https://leetcode.com/problems/last-day-where-you-can-still-cross
    /** Algorithm
        1. Use binary search (1 ..cells.length) to see if you can traverse the flooded matrix
        2. For the given pivot, flood the first cells[0]... cells[pivot] cells.
        3. Apply basic DFS to attempt to traverse: stop if you the last row and you are on land.
        4. If you can traverse, then your pivot needs to be higher (low = pivot + 1)
        5. If you can't traverse, then lower your high (high = pivot -1)
         6. Return low.
     */
    public int latestDayToCross(int row, int col, int[][] cells) {
        // cells[pivot] signifies the day pivot + 1
        // thus, low = 1 actually is cells[0].
        int low = 1, high = cells.length, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canTraverse(row, col, pivot, cells)) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low;
    }

    private boolean canTraverse(int row, int col, int fillLimit, int[][] cells) {
        boolean[][] waterMap = new boolean[row][col];
        for (int i = 0; i <= fillLimit; i++) {
            waterMap[cells[i][0] - 1][cells[i][1] - 1] = true;
        }
        boolean[] canTraverse = {false};
        for (int j = 0; j < col; j++) {
            traverseWaterMap(waterMap, 0, j, canTraverse);
        }
        return canTraverse[0];
    }

    private void traverseWaterMap(boolean[][] waterMap, int i, int j, boolean[] canTraverse) {
        if (canTraverse[0] ||  i < 0 || i >= waterMap.length || j < 0 || j >= waterMap[0].length || waterMap[i][j]) {
            return;
        }
        waterMap[i][j] = true;
        if (i == waterMap.length - 1) {
            canTraverse[0] = true;
        } else {
            traverseWaterMap(waterMap, i - 1, j, canTraverse);
            traverseWaterMap(waterMap, i, j + 1, canTraverse);
            traverseWaterMap(waterMap, i + 1, j, canTraverse);
            traverseWaterMap(waterMap, i, j - 1, canTraverse);
        }
    }
}
