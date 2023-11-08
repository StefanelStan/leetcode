package com.ss.leetcode.LC2023.november;

public class DetermineIfACellIsReachableAtAGivenTime {
    // https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time
    /** Algorithm
        1. Fail fast: if star == end
            - if your t == 1 return false. You cannon step out and in the same cell in 1 step
            - else return true
        2. The two points form a rectangle of given width (Math.abs(xs - fx) and height(Math.abs(xy - fy))).
        3. The two points are situated at the opposite corners of rectangle.
        4. You need to find out the minimum steps to traverse the whole rectangle.
            If t is equal or greater, then you can traverse it in t.
            - Why? Before last step you can do left, right, up and do extra steps, just to fill in the extra steps till T.
        5. Travelling a rectangle from opposite corners takes max(width, height) steps.
            As you already sit on the corner, the steps needed are max - 1.
        6. Return neededSteps <= T.
     */
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        int width = Math.abs(sx-fx) + 1;
        int height = Math.abs(sy - fy) + 1;
        return Math.max(width, height) -1 <= t;
    }
}
