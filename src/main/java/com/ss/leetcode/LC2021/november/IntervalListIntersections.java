package com.ss.leetcode.LC2021.november;

import java.util.Arrays;

public class IntervalListIntersections {
    // https://leetcode.com/problems/interval-list-intersections/
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }
        int[][] intersections = new int[firstList.length + secondList.length][2];
        int[] index = {0};
        getIntersections(firstList, 0, secondList, 0, intersections, index);
        return Arrays.copyOf(intersections, index[0]);
    }

    private void getIntersections(int[][] fList, int fIndex, int[][] sList, int sIndex, int[][] intersections, int[] iIndex) {
        if (fIndex >= fList.length && sIndex >= sList.length) {
            return;
        }
        if (fIndex >= fList.length) {
            copyRangeInterval(sList, sIndex, intersections, iIndex);
        } else if (sIndex >= sList.length) {
            copyRangeInterval(fList, fIndex, intersections, iIndex);
        } else {
            int maxStart = Math.max(fList[fIndex][0], sList[sIndex][0]);
            int minEnd = Math.min(fList[fIndex][1], sList[sIndex][1]);

            if (containsValues(maxStart, minEnd, fList[fIndex]) &&
                containsValues(maxStart, minEnd, sList[sIndex])) {
                intersections[iIndex[0]] = new int[]{maxStart, minEnd};
                iIndex[0]++;
            }
            // decide which index we move forward;
            if (minEnd == fList[fIndex][1]) {
                fIndex++;
            } else if (minEnd == sList[sIndex][1]) {
                sIndex++;
            }
            getIntersections(fList, fIndex, sList, sIndex, intersections, iIndex);
        }
    }

    private void copyRangeInterval(int[][] list, int lIndex, int[][] intersections, int[] iIndex) {
        System.arraycopy(list, lIndex, intersections, iIndex[0], list.length - lIndex);
    }

    private boolean containsValues(int value1, int value2, int[] interval) {
        return interval[0] <= value1 && value1 <= interval[1] &&
            interval[0] <= value2 && value2 <= interval[1];
    }
}
