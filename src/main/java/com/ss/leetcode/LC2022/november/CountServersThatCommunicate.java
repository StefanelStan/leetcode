package com.ss.leetcode.LC2022.november;

public class CountServersThatCommunicate {
    // https://leetcode.com/problems/count-servers-that-communicate/
    /** Algorithm
         1. In order for a server to communicate, there needs to be at least 2 servers on same row or column
         2. Traverse the matrix and hold an int[] serversPerRow and int[] serversPerColumn.
         3. If grid[i][j] == 1, increase the serversPerRow[i] and serversPerColumn[j]
         4. Traverse again and if the grid[i][j] == 1 and (serversPerRow[i] > 1 || serversPerColumn[j] > 1), then
         the server can be connected.
         5. Return the total numbers of connected servers.
     */
    public int countServers(int[][] grid) {
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        setRowColumnServerCount(grid, rowCount, colCount);
        return countServers(grid, rowCount, colCount);
    }

    private void setRowColumnServerCount(int[][] grid, int[] rowCount, int[] colCount) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowCount[i] += grid[i][j];
                colCount[j] += grid[i][j];
            }
        }
    }

    private int countServers(int[][] grid, int[] rowCount, int[] colCount) {
        int servers = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    servers++;
                }
            }
        }
        return servers;
    }
}
