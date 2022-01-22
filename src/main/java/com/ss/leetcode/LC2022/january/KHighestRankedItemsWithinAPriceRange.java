package com.ss.leetcode.LC2022.january;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KHighestRankedItemsWithinAPriceRange {
    // https://leetcode.com/contest/biweekly-contest-70/problems/k-highest-ranked-items-within-a-price-range/
    // Not working as needs to determine the distance (Dijkstra Distance)
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> highestRanked = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        parseGrid(grid, pricing[0], pricing[1], start[0], start[1], start, items, visited);
        Collections.sort(items);
        for (int i = 0; i < items.size() && i < k; i++) {
            highestRanked.add(List.of(items.get(i).row, items.get(i).col));
        }
        return highestRanked;
    }

    private void parseGrid(int[][] grid, int lowPrice, int highPrice, int x, int y, int[] start, List<Item> items, boolean[][] visited) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || visited[x][y] || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
         if (!(grid[x][y] < lowPrice || grid[x][y] > highPrice)) {
             items.add(new Item(Math.abs(start[0] - x) + Math.abs(start[1] - y), grid[x][y], x, y));
         }
        parseGrid(grid, lowPrice, highPrice, x - 1, y, start, items, visited);
        parseGrid(grid, lowPrice, highPrice, x + 1, y, start, items, visited);
        parseGrid(grid, lowPrice, highPrice, x, y - 1, start, items, visited);
        parseGrid(grid, lowPrice, highPrice, x, y + 1, start, items, visited);
    }

    private static class Item implements Comparable<Item>{
        int distance;
        int prince;
        int row;
        int col;

        public Item(int distance, int prince, int row, int col) {
            this.distance = distance;
            this.prince = prince;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Item o) {
            int distanceComp = Integer.compare(distance, o.distance);
            if (distanceComp == 0) {
                int priceComp = Integer.compare(prince, o.prince);
                if (priceComp == 0) {
                    int rowComp = Integer.compare(row, o.row);
                    if (rowComp == 0) {
                        return Integer.compare(col, o.col);
                    } else {
                        return rowComp;
                    }
                } else {
                    return priceComp;
                }
            } else {
                return distanceComp;
            }
        }
    }
}
