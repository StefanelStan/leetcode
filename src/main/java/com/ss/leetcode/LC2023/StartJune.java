package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.june.ShortestPathInBinaryMatrix;

public class StartJune {
    public static void main(String[] args) {
        StartJune start = new StartJune();

        start.shortestPathInBinaryMatrix();
    }

    public void shortestPathInBinaryMatrix() {
        ShortestPathInBinaryMatrix spibm = new ShortestPathInBinaryMatrix();

        System.out.println("2 == " + spibm.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println("4 == " + spibm.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println("-1 == " + spibm.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }
}
