package com.ss.leetcode.LC2024.may;

import java.util.Arrays;

public class MaximumNumberOfGroupsEnteringACompetition {
    // https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition
    public int maximumGroups(int[] grades) {
        int[] buckets = getBuckets(grades);
        return getTotalGroups(buckets);
    }

    private int[] getBuckets(int[] grades) {
        int maxGrade = 0;
        for (int grade : grades) {
            maxGrade = Math.max(maxGrade, grade);
        }
        int[] buckets = new int[maxGrade + 1];
        for (int grade : grades) {
            buckets[grade]++;
        }
        return buckets;
    }

    private int getTotalGroups(int[] buckets) {
        int prevGroupSize = 0, prevGroupGrades = 0;
        int currentGroupSize = 0, currentGroupGrades = 0;
        int totalGroups = 0;
        for (int i = 0; i < buckets.length; i++) {
            while(buckets[i] > 0) {
                currentGroupSize++;
                currentGroupGrades += i;
                buckets[i]--;
                if (currentGroupSize > prevGroupSize && currentGroupGrades > prevGroupGrades) {
                    prevGroupSize = currentGroupSize;
                    prevGroupGrades = currentGroupGrades;
                    currentGroupSize = 0;
                    currentGroupGrades = 0;
                    totalGroups++;
                }
            }
        }
        return totalGroups;
    }

    public int maximumGroups2(int[] grades) {
        Arrays.sort(grades);
        int prevGroupSize = 0, prevGroupGrades = 0;
        int currentGroupSize = 0, currentGroupGrades = 0;
        int totalGroups = 0;
        for (int grade : grades) {
            currentGroupSize++;
            currentGroupGrades += grade;
            if (currentGroupSize > prevGroupSize && currentGroupGrades > prevGroupGrades) {
                prevGroupSize = currentGroupSize;
                prevGroupGrades = currentGroupGrades;
                currentGroupSize = 0;
                currentGroupGrades = 0;
                totalGroups++;
            }
        }
        return totalGroups;
    }
}
