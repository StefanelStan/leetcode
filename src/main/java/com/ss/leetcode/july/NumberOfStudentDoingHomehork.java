package com.ss.leetcode.july;

public class NumberOfStudentDoingHomehork {
    // https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int times = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                times++;
            }
        }
        return times;
    }
}
