package com.ss.leetcode.LC2025.january;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
    // https://leetcode.com/problems/map-of-highest-peak
    private static final int[][] DIRECTIONS = {{-1, 0},{0, 1},{1, 0},{0,-1}};
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> nextToVisit = new LinkedList<>();
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        int[][] peaks = markPeaks(isWater, nextToVisit, visited);
        visitCells(peaks, nextToVisit, visited);
        return peaks;
    }

    private int[][] markPeaks(int[][] isWater, Queue<int[]> nextToVisit, boolean[][] visited) {
        int[][] peaks = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    peaks[i][j] = 0;
                    visited[i][j] = true;
                    nextToVisit.add(new int[]{i, j});
                } else {
                    peaks[i][j] = -1;
                }
            }
        }
        return peaks;
    }

    private void visitCells(int[][] peaks, Queue<int[]> nextToVisit, boolean[][] visited) {
        int heightToPut = 1, size, x, y;
        while(!nextToVisit.isEmpty()) {
            size = nextToVisit.size();
            while (size > 0) {
                x = nextToVisit.peek()[0];
                y = nextToVisit.poll()[1];
                for (int[] direction : DIRECTIONS) {
                    if (canBeVisited(visited, direction[0] + x, direction[1] + y)) {
                        peaks[direction[0] + x][direction[1] +y] = heightToPut;
                        visited[direction[0] + x][direction[1] + y] = true;
                        nextToVisit.add(new int[]{direction[0] + x, direction[1] + y});
                    }
                }
                size--;
            }
            heightToPut++;
        }
    }

    private boolean canBeVisited(boolean[][] visited, int x, int y) {
        return x >= 0 && x < visited.length && y >= 0 && y < visited[0].length && !visited[x][y];
    }

    private int[][] heighestPeak2(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] mat = new int[m][n];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = isWater[i][j] == 0 ? 1 : 0;
            }
        }
        int[][] distance = new int[m][n];
        // traverse left-> right, up->down
        int temp1, temp2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    temp1 = i == 0 ? 20001 : distance[i-1][j];
                    temp2 = j == 0 ? 20001 : distance[i][j-1];
                    distance[i][j] = 1 + Math.min(temp1, temp2);
                }
            }
        }
        // traverse right->left, down->up
        for (int i = m -1; i >= 0; i--) {
            for (int j = n -1; j >=0; j--) {
                if (mat[i][j] == 1) {
                    temp1 = i == m - 1 ? 20001 : distance[i+1][j];
                    temp2 = j == n - 1 ? 20001 : distance[i][j+1];
                    distance[i][j] = Math.min(distance[i][j], 1 + Math.min(temp1, temp2));
                }
            }
        }
        return distance;
    }

}
