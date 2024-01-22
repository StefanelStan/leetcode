package com.ss.leetcode.LC2024.january;

public class MaximumNumberOfWeeksForWhichYouCanWork {
    // https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work
    /** Algorithm
        1. If the longest project > sum other_projects, then you can finish all other projects 2 * other_projects + 1
        2. Else, if other_projects >= longestProject, then you can finish the longest projest alongside the other projects.
     */
    public long numberOfWeeks(int[] milestones) {
        int longestProject = 0;
        long totalProjects = 0;
        for (int milestone : milestones) {
            totalProjects += milestone;
            longestProject = Math.max(longestProject, milestone);
        }
        long otherProjects = totalProjects - longestProject;
        if (longestProject > otherProjects) {
            return (long)otherProjects * 2 + 1;
        } else {
            return (long)totalProjects;
        }
    }
}
