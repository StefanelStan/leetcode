package com.ss.leetcode.LC2021.november;

import java.util.Arrays;

public class AssignCookies {
    // https://leetcode.com/problems/assign-cookies/
    /** Algorithm
        1. Sort the greed and sizes
        2. With two indices child and cookie both starting from 0
        3. While child < g.length and cookie < s.length
            - If you can satisfy the current greed (g[child] <= s[cookie]), then assign the cookie to current child and move on
            - Else (the size is too small for current child) move to next cookie size and see if this size suits the current child.
        4. Return the index of last child.
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
}
