package com.ss.leetcode.LC2022.november;

public class RectangleArea {
    // https://leetcode.com/problems/rectangle-area/
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = getRectangleArea(ax1, ay1, ax2, ay2);
        int area2 = getRectangleArea(bx1, by1, bx2, by2);
        int commonArea = getCommonArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        return area1 + area2 - commonArea;
    }

    private int getRectangleArea(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) * Math.abs(y2 - y1);
    }

    private int getCommonArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int hOverlappingWidth = getAxisOverlappingWidth(ax1, ax2, bx1, bx2);
        if (hOverlappingWidth > 0) {
            hOverlappingWidth *= getAxisOverlappingWidth(ay1, ay2, by1, by2);
        }
        return Math.max(0, hOverlappingWidth);
    }

    private int getAxisOverlappingWidth(int r1s, int r1e, int r2s, int r2e) {
        int overlapping = Math.max(checkSegment(r1s, r1e, r2s, r2e), checkSegment(r2s, r2e, r1s, r1e));
        return Math.max(0, overlapping);
    }

    private int checkSegment(int r1s, int r1e, int r2s, int r2e) {
        if (r2e <= r1s || r1e <= r2s) {
            return 0;
        }
        return Math.min(r2e, r1e) - Math.max(r1s, r2s);
    }
}
