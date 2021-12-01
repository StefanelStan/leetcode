package com.ss.leetcode.LC2021.november;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
    // https://leetcode.com/problems/k-closest-points-to-origin/
    public int[][] kClosest(int[][] points, int k) {
        DistancePoint[] distances = new DistancePoint[points.length];
        int[][] kClosest = new int[k][2];
        double distance = 0;
        for(int i = 0; i < points.length; i++) {
            distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            distances[i] = new DistancePoint(distance, points[i]);
        }
        Arrays.sort(distances, Comparator.comparingDouble(d -> d.distance));
        for (int i = 0; i < k; i++) {
            kClosest[i][0] = distances[i].point[0];
            kClosest[i][1] = distances[i].point[1];
        }
        return kClosest;
    }

    private static class DistancePoint {
        double distance;
        int[] point;

        public DistancePoint(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }
}
