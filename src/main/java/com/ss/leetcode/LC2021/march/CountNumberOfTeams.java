package com.ss.leetcode.LC2021.march;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int numberOfTeams = 0;
        int leftLesser = 0, leftGreater = 0, rightLess = 0, rightGreater = 0;
        for (int j = 1; j < rating.length - 1; j++) {
            leftLesser = 0;
            leftGreater = 0;
            rightLess = 0;
            rightGreater = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftLesser++;
                } else {
                    leftGreater++;
                }            }
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[j] < rating[k]) {
                    rightGreater++;
                } else {
                    rightLess++;
                }
            }
            numberOfTeams = numberOfTeams + leftLesser * rightGreater + leftGreater * rightLess;
        }
        return numberOfTeams;
    }
}
