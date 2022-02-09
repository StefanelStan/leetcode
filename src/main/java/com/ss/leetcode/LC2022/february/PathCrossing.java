package com.ss.leetcode.LC2022.february;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    // https://leetcode.com/problems/path-crossing/
    public boolean isPathCrossing(String path) {
        Set<Point> visited = new HashSet<>();
        Point currentLoc = new Point(0,0);
        visited.add(currentLoc);
        for(char c : path.toCharArray()) {
            currentLoc = getPoint(c, currentLoc.x, currentLoc.y);
            if(!visited.add(currentLoc)) {
                return true;
            }
        }
        return false;
    }

    private Point getPoint(char c, int currX, int currY) {
        switch(c) {
            case 'N': return new Point(currX, currY +1);
            case 'S': return new Point(currX, currY -1);
            case 'E': return new Point(currX +1, currY);
            default:  return new Point(currX -1, currY);
        }
    }
}

    private static class VisitedPoint {
        int[] point;

        public VisitedPoint(int x, int y) {
            this.point = new int[]{x,y};
        }

        @Override
        public boolean equals(Object obj) {
            VisitedPoint vp = (VisitedPoint) obj;
            return this.point[0] == vp.point[0] && this.point[1] == vp.point[1];
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(point);
        }
    }
}
