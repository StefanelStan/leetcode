package com.ss.leetcode.LC2023.may;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    // https://leetcode.com/problems/equal-row-and-column-pairs
    /** Algorithm
        ! Why using String hash? Arrays.hashCode(int[]) cause collision on edge cases of
        [2,1] and [1,32].
        1. Calculate and count the hash of columns, storing it into a map
            Append a comma between each number to avoid collisions )eg: [31,1] vs [3,11]
            Without comma, they would both be 311
        2. For each row, calculate its hash and look it up in the map. Get its count or 0.
        3. Add the count to the sum of pairs
        4. Return pairs;
     */
    public int equalPairs(int[][] grid) {
        int pairs = 0;
        Map<String, Integer> columns = getHashOfColumns(grid);
        for (int[] row : grid) {
            pairs += columns.getOrDefault(toString(row), 0);
        }
        return pairs;
    }

    private Map<String, Integer> getHashOfColumns(int[][] grid) {
        Map<String, Integer> columns = new HashMap<>();
        StringBuilder stb = new StringBuilder(grid[0].length);
        for (int j = 0; j < grid[0].length; j++) {
            stb.setLength(0);
            for (int[] row : grid) {
                stb.append(row[j]).append(',');
            }
            columns.merge(stb.toString(), 1, Integer::sum);
        }
        return columns;
    }

    private String toString(int[] row) {
        StringBuilder stb = new StringBuilder(row.length);
        for (int nr : row) {
            stb.append(nr).append(',');
        }
        return stb.toString();
    }
}
