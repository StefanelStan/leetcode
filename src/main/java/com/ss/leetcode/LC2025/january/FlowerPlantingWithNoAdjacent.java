package com.ss.leetcode.LC2025.january;

import java.util.ArrayList;
import java.util.List;

public class FlowerPlantingWithNoAdjacent {
    // https://leetcode.com/problems/flower-planting-with-no-adjacent
    /** Algorithm
        1. Get the adjacency list; List<Integer>[n+1].
        2. Use an int[] gardenFlowers to mark each flower in each garden.
        3. Start from the 1st to last garden and iterate over the list of neighbours.
            - For each garden, mark the flower type of its neighbours into a boolean[5].
            - After each iteration, return the index (from 1) that has the first false. (no flower of that type there).
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] neighbours = getNeighbours(n, paths);
        int[] gardenFlowers = new int[n];
        for (int i = 0; i < neighbours.length - 1; i++) {
            gardenFlowers[i] = plantFlower(gardenFlowers, neighbours[i+1]);
        }
        return gardenFlowers;
    }

    private int plantFlower(int[] gardenFlowers, List<Integer> neighbours) {
        if (neighbours == null) {
            return 1;
        }
        boolean[] otherFlowers = new boolean[5];
        for (int neighbour : neighbours) {
            otherFlowers[gardenFlowers[neighbour - 1]] = true;
        }
        int index = 1;
        while (otherFlowers[index]) {
            index++;
        }
        return index;
    }

    private List<Integer>[] getNeighbours(int n, int[][] paths) {
        List<Integer>[] neighbours = new List[n + 1];
        for (int[] path : paths) {
            if (neighbours[path[0]] == null) {
                neighbours[path[0]] = new ArrayList<>();
            }
            if (neighbours[path[1]] == null) {
                neighbours[path[1]] = new ArrayList<>();
            }
            neighbours[path[0]].add(path[1]);
            neighbours[path[1]].add(path[0]);
        }
        return neighbours;
    }
}
