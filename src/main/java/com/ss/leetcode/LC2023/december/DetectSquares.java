package com.ss.leetcode.LC2023.december;

public class DetectSquares {
    // https://leetcode.com/problems/detect-squares
    /** Algorithm
        1. Use an int[1001][1001] points to mark how many points you have on your board
        2. Given a point on your board, you need to travel left and right and search up and down for your points
         3. Travelling LEFT/RIGHT in constant distance, you will check for points situated at up and down
            - LEFT UP:   [x-i][y] * [x-i][y+i] * [x][y+i]
            - LEFT DOWN: [x-i][y] * [x-i][y-i] * [x][y-i]
            - RIGHT UP:  [x+i][y] * [x+i][y+i] * [x][y+i]
            - RIGHT DOWN:[x+i][y] * [x+i][y-i] * [x][y-i]
        4. You don't need to travel from 0 to x (left) and x+1 to 1001, but you can cache and retain each min/max
             for each point.
     */
    private int[][] points;
    private int[][] minMaxRow;
    private int minCol = 1002, maxCol = -1;
    public DetectSquares() {
        points = new int[1001][1001];
        minMaxRow = new int[1001][2];
        for(int i = 0; i < 1001; i++) {
            minMaxRow[i][0] = 1000;
        }
    }

    public void add(int[] point) {
        minMaxRow[point[1]][0] = Math.min(minMaxRow[point[1]][0], point[0]);
        minMaxRow[point[1]][1] = Math.max(minMaxRow[point[1]][1], point[0]);
        minCol = Math.min(minCol, point[1]);
        maxCol = Math.max(maxCol, point[1]);
        points[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        if (maxCol == -1) {
            return 0;
        }
        return countLeft(point[0], point[1]) + countRight(point[0], point[1]);
    }

    public int countLeft(int x, int y) {
        int limit = Math.min(x - minMaxRow[y][0], Math.max(maxCol - y, y - minCol));
        int total = 0;
        for (int i = 1; i <= limit; i++) {
            total += points[x-i][y] * ofPoint(x-i, y+i) * ofPoint(x, y+i);
            total += points[x-i][y] * ofPoint(x-i, y-i) * ofPoint(x, y-i);
        }
        return total;
    }

    public int countRight(int x, int y) {
        int limit = Math.min(minMaxRow[y][1] - x, Math.max(maxCol - y, y - minCol));
        int total = 0;
        for (int i = 1; i <= limit; i++) {
            total += points[x+i][y] * ofPoint(x+i, y+i) * ofPoint(x, y+i);
            total += points[x+i][y] * ofPoint(x+i, y-i) * ofPoint(x, y-i);
        }
        return total;
    }

    private int ofPoint(int x, int y) {
        return y < 0 || y > 1000 ? 0 : points[x][y];
    }
}
