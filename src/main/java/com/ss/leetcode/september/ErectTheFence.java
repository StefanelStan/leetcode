package com.ss.leetcode.september;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ErectTheFence {
    // Determine the 3 points orientation;
    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int[][] outerTrees(int[][] points) {
        // sort them by x and then by y.
        Arrays.sort(points, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
        LinkedList<int[]> hull = new LinkedList<>();
        for (int[] point : points) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) > 0) {
                hull.pollLast();
            }
            hull.addLast(point);
        }
        hull.pollLast();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0) {
                hull.pollLast();
            }
            hull.addLast(points[i]);
        }
        // result may contain duplicate results. We only need unique ones.
        Set<int[]> outerTrees = new HashSet<>(hull);
        return outerTrees.toArray(new int[outerTrees.size()][]);
    }
}
