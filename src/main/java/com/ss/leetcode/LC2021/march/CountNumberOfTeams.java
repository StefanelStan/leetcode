package com.ss.leetcode.LC2021.march;

public class CountNumberOfTeams {
    // https://leetcode.com/problems/count-number-of-teams
    /** Algorithm
        1. For each index i [1..n-2] determine how many are greater/lesser on the left and on the right
        2. So, inside 1st for
            - travel with j from [0, i-1] and if num[j] < num[i], increment leftLesser else increment leftGreater
            - travel with j from [i+1, n-1] and if num[j] < num[i], increment rightLesser else increment rightGreater
        3. For each i, the teams increment by leftLesser * rightGreater + leftGreater + rightLesser.
     */
    public int numTeams(int[] rating) {
        int teams = 0, leftLesser, leftGreater, rightLesser, rightGreater;
        for (int i = 1; i < rating.length - 1; i++) {
            leftLesser = leftGreater = rightLesser = rightGreater = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftLesser++;
                } else {
                    leftGreater++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    rightLesser++;
                } else {
                    rightGreater++;
                }
            }
            teams += leftLesser * rightGreater + leftGreater * rightLesser;
        }
        return teams;
    }
}
