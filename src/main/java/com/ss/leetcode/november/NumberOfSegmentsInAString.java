package com.ss.leetcode.november;

public class NumberOfSegmentsInAString {
    // https://leetcode.com/problems/number-of-segments-in-a-string/
    public int countSegments(String s) {
        int segments = 0;
        boolean insideSegment = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (!insideSegment) {
                    insideSegment = true;
                    segments++;
                }
            } else {
                insideSegment = false;
            }
        }
        return segments;
    }
}
