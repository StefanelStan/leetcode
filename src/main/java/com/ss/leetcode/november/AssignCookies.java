package com.ss.leetcode.november;

import java.util.Arrays;

public class AssignCookies {
    // https://leetcode.com/problems/assign-cookies/
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int lastContent = s.length - 1;
        int content = 0;
        for (int child = g.length - 1; child >= 0 && lastContent >= 0; child--) {
            if (s[lastContent] >= g[child]) {
                content++;
                lastContent--;
            }
        }
        return content;
    }
}
