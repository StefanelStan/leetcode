package com.ss.leetcode.LC2024.january;

public class OutOfBoundaryPaths {
    // https://leetcode.com/problems/out-of-boundary-paths
    /** Algorithm
        1. Use an Integer[m][n][] cache to cache number of ways you can reach the limit
            if you sit at cell [x][y] and have [r] remaining moves
        2. Your recursive function will check if you can reach the limit (if you are not in the middle and the
            remaining steps are insufficient to reach any edge)
        3. If you reach the edge, return 1;
        4. Else, your cache[x][y][r] is moveUp(x-1, r, r-1, cache) + moveDown + moveLeft + moveright.
        5. To avoid overflow, modulo each partial sum.
     */
    private static final int MODULO = 1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] cacheMoves = new Integer[m][n][];
        return moveBall(startRow, startColumn, maxMove, maxMove, cacheMoves);
    }

    private int moveBall(int x, int y, int maxMove, int remain, Integer[][][] cacheMoves) {
        if (remain <= x && (x + remain < cacheMoves.length) && remain <= y && y + remain < cacheMoves[0].length ) {
            return 0;
        }
        if (x < 0 || x == cacheMoves.length || y < 0 || y == cacheMoves[0].length) {
            return 1;
        }
        if (cacheMoves[x][y] == null) {
            cacheMoves[x][y] = new Integer[maxMove + 1];
        }
        if (cacheMoves[x][y][remain] == null) {
            cacheMoves[x][y][remain] = moveBall(x - 1, y, maxMove, remain -1, cacheMoves);
            cacheMoves[x][y][remain] = (cacheMoves[x][y][remain] + moveBall(x, y + 1, maxMove, remain -1, cacheMoves)) % MODULO;
            cacheMoves[x][y][remain] = (cacheMoves[x][y][remain] + moveBall(x + 1, y, maxMove, remain -1, cacheMoves)) % MODULO;
            cacheMoves[x][y][remain] = (cacheMoves[x][y][remain] + moveBall(x, y - 1, maxMove, remain -1, cacheMoves)) % MODULO;
        }
        return cacheMoves[x][y][remain];
    }
}
