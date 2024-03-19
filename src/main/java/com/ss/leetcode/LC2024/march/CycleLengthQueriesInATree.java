package com.ss.leetcode.LC2024.march;

import java.util.HashMap;
import java.util.Map;

public class CycleLengthQueriesInATree {
    // https://leetcode.com/problems/cycle-length-queries-in-a-tree
    /** Algorithm
        1. Having a number n, we know that we can travel UPSTREAM by dividing it by 2.
            - EG: 1000 -> 500 -> 250 -> 125 -> 62 -> 31 -> 15 -> 7 -> 3 -> 1
        2. Each query has two numbers: left/ right OR min and max.
        3. The cycle is determined by LCA (lowest common ancestor).
        4. While min != max:
            - divide max by 2 and increase steps.
            - if min becomes > max, divide min by 2 and increase steps.
            - stop when min == max and return steps + 1.
     */
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] cycleLengths =  new int[queries.length];
        for (int i = 0; i < cycleLengths.length; i++) {
            cycleLengths[i] = findLCAOf(Math.min(queries[i][0], queries[i][1]), Math.max(queries[i][0], queries[i][1]));
        }
        return cycleLengths;
    }

    private int findLCAOf(int min, int max) {
        int steps = 0;
        while (min != max) {
            if (max > min) {
                max = max / 2;
                steps++;
            }
            if (min > max) {
                min = min / 2;
                steps++;
            }
        }
        return steps + 1;
    }

    public int[] cycleLengthQueries2(int n, int[][] queries) {
        int[] cycleLengths =  new int[queries.length];
        for (int i = 0; i < cycleLengths.length; i++) {
            Map<Integer, Integer> leftPath = getPathOf(queries[i][0]);
            cycleLengths[i] = findLCAOf(leftPath, queries[i][1]);
        }
        return cycleLengths;
    }

    private Map<Integer, Integer> getPathOf(int target) {
        int steps = 0;
        Map<Integer, Integer> path = new HashMap<>();
        path.put(target, 0);
        while (target > 0) {
            target = target / 2;
            path.put(target, ++steps);
        }
        return path;
    }

    private int findLCAOf(Map<Integer, Integer> path, int target) {
        int steps = 0;
        Integer foundInPath;
        while(target > 0) {
            foundInPath = path.get(target);
            if (foundInPath != null) {
                return steps + foundInPath + 1;
            }
            target = target / 2;
            steps++;
        }
        return 0;
    }
}
