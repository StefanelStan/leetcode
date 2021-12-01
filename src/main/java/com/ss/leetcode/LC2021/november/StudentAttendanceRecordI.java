package com.ss.leetcode.LC2021.november;

public class StudentAttendanceRecordI {
    // https://leetcode.com/problems/student-attendance-record-i/
    public boolean checkRecord(String s) {
        int absentDays = 0, lateDays = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') {
                lateDays = 0;
                if (++absentDays > 1) {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                if (++lateDays >= 3) {
                    return false;
                }
            } else {
                lateDays = 0;
            }
        }
        return true;
    }
}
