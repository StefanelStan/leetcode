package com.ss.leetcode.LC2021.november;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    // https://leetcode.com/problems/k-closest-points-to-origin/
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> reverse = new PriorityQueue<>((a,b) ->
            ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));
        for(int[] point : points) {
            reverse.add(point);
            if(reverse.size() > k) {
                reverse.remove();
            }
        }
        int[][] answer = new int[k][2];
        int i = 0;
        while(!reverse.isEmpty()) {
            System.arraycopy(reverse.remove(), 0, answer[i++], 0, 2);
        }
        return answer;
    }

    public int[][] kClosest2(int[][] points, int k) {
        double[][] dPoints = new double[points.length][2];
        int[][] kClosest = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            dPoints[i][0] = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            dPoints[i][1] = i;
        }
        Arrays.sort(dPoints, Comparator.comparingDouble(a -> a[0]));
        for (int i = 0; i < k; i++) {
            kClosest[i] = points[(int)dPoints[i][1]];
        }
        return kClosest;
    }

    public int[][] kClosest3(int[][] points, int k) {
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
