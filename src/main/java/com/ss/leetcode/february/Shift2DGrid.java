package com.ss.leetcode.february;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shift2DGrid {
    // https://leetcode.com/problems/shift-2d-grid/
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] shiftedGrid = new int[grid.length][grid[0].length];
        int newi = 0;
        int newj = 0;
        int gridSize = grid.length * grid[0].length;
        int nextLocation = 0;
        int currentLocation = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                nextLocation = (currentLocation + k) % gridSize;
                newi = nextLocation / grid[0].length;
                newj = nextLocation % grid[newi].length;
                shiftedGrid[newi][newj] = anInt;
                currentLocation++;
            }
        }
        List<List<Integer>> returnValue = new LinkedList<>();
        for (int[] ints : shiftedGrid) {
            List<Integer> line = new LinkedList<>();
            for (int anInt : ints) {
                line.add(anInt);
            }
            returnValue.add(line);
        }

        return returnValue;
    }

    public String printShiftedGrid(int[][] grid, int k) {
        final List<List<Integer>> shifted = shiftGrid(grid, k);
        StringBuilder stb = new StringBuilder(grid.length * grid.length);
        for(List<Integer> line : shifted) {
            stb.append(line);
        }
        return stb.toString();
    }
}
