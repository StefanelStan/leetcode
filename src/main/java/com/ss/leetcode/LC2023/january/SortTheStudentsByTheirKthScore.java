package com.ss.leetcode.LC2023.january;

import java.util.Arrays;

public class SortTheStudentsByTheirKthScore {
    // https://leetcode.com/problems/sort-the-students-by-their-kth-score
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a,b) -> Integer.compare(b[k], a[k]));
        return score;
    }
}
