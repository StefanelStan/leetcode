package com.ss.leetcode.LC2025.january;

public class AlternatingGroupsII {
    // https://leetcode.com/problems/alternating-groups-ii
    /** Algorithm
        1. As you need a window of k size, in a wrapping way, your right pointer needs to travel n + k - 3 steps.
        2. Traverse with left, right (0,1) for n + k - 3 steps, keeping track of current window size.
            - left will be at the left of right by 1 step
        3. If your color[right] != color[left], then increment window size.
            - if window size is k, add 1 to groups and reduce size by 1
        4. If color[right] == color[left], then you need to close/reset the window, set size = 1.
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int size = 1, steps = 0;
        int groups = 0;
        for (int left = 0, right = 1; steps <= colors.length + k - 3; steps++) {
            if (colors[right] != colors[left]) {
                size++;
                if (size == k) {
                    groups++;
                    size--;
                }
            } else {
                size = 1;
            }
            left = (left + 1) % colors.length;
            right = (right + 1) % colors.length;
        }
        return groups;
    }
}
