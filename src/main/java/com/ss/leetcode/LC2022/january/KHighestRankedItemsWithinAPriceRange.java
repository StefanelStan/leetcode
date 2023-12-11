package com.ss.leetcode.LC2022.january;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class KHighestRankedItemsWithinAPriceRange {
    // https://leetcode.com/contest/biweekly-contest-70/problems/k-highest-ranked-items-within-a-price-range/
    /** Algorithm
        1. Use a Queue to add the good cell to visit. Add (start[0],start[1]) first.
        2. Use OOP and create a class PriceCell (row, col, price, distance) for cleaner code
        3. From current/head cell, try to add the next 4 cells in the queue (addLast) only if x/y is not outside the range or value == 0
        4. From the queue, if the price is OK, add it to a 2nd list.
        5. Sort the 2nd list using util.comparator and return the first k elements.
     */
    int[][] directions = {{-1, 0},{0, 1}, {1, 0}, {0, -1}};
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        if (grid[start[0]][start[1]] == 0) {
            return new ArrayList<>();
        }
        LinkedList<PriceCell> queue = new LinkedList<>();
        List<PriceCell> validCells = new ArrayList<>();
        queue.add(new PriceCell(start[0], start[1], grid[start[0]][start[1]], 0));
        grid[start[0]][start[1]] = 0;
        PriceCell currentCell;
        while(!queue.isEmpty()) {
            currentCell = queue.removeFirst();
            if (currentCell.price > 1 && pricing[0] <= currentCell.price && currentCell.price <= pricing[1]) {
                validCells.add(currentCell);
            }
            addNeighboursToQueue(currentCell, grid, queue);
        }
        return getKHighestPrices(validCells, k);
    }

    private List<List<Integer>> getKHighestPrices(List<PriceCell> validCells, int k) {
        validCells.sort(Comparator.comparingInt(PriceCell::getDistance).thenComparingInt(c -> c.price).thenComparingInt(c -> c.row).thenComparingInt(c -> c.col));
        List<List<Integer>> range = new ArrayList<>(Math.min(k, validCells.size()));
        PriceCell current;
        for (int i = 0; i < validCells.size() && k > 0; i++, k--) {
            current = validCells.get(i);
            range.add(List.of(current.row, current.col));
        }
        return range;
    }

    private void addNeighboursToQueue(PriceCell cell, int[][] grid, LinkedList<PriceCell> queue) {
        PriceCell cellToAdd;
        for (int[] direction : directions) {
            if (isValidNextCell(cell.row + direction[0], cell.col + direction[1], grid)) {
                cellToAdd = new PriceCell(cell.row + direction[0], cell.col + direction[1],
                    grid[cell.row + direction[0]][cell.col + direction[1]], cell.distance + 1);
                grid[cellToAdd.row][cellToAdd.col] = 0;
                queue.addLast(cellToAdd);
            }
        }
    }

    private boolean isValidNextCell(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0;
    }

    private static class PriceCell {
        int row;
        int col;
        int price;
        int distance;

        public PriceCell(int row, int col, int price, int distance) {
            this.row = row;
            this.col = col;
            this.price = price;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }
    }


    // Not working as needs to determine the distance (Dijkstra Distance)
    public List<List<Integer>> highestRankedKItems2(int[][] grid, int[] pricing, int[] start, int k) {
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
