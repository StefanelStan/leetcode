package com.ss.leetcode.LC2023.april;

import java.util.Arrays;

public class FormSmallestNumberFromTwoDigitArrays {
    // https://leetcode.com/contest/biweekly-contest-101/problems/form-smallest-number-from-two-digit-arrays/

    /** Algorithm
     *  1. Use a boolean[] to mark if a digit is present or not for both arrays
     *  2. Traverse both booleans[] and if present1[i] && present2[i] (both digits are present) return the index
     *  3. While traversing, keep track of the first present digit in each nums/booleans. (firstPresent1, firstPresent2)
     *  4. Return min(fp1, fp2) * 10 + max(fp1, fp2).
     */
    public int minNumber(int[] nums1, int[] nums2) {
        boolean found1[] = getFound(nums1);
        boolean found2[] = getFound(nums2);
        int firstLow = -1, secondLow = -1;
        for (int i = 1; i < 10; i++) {
            if (found1[i] && found2[i]) {
                return i;
            }
            if (found1[i] && firstLow == -1) {
                firstLow = i;
            }
            if(found2[i] && secondLow == -1) {
                secondLow = i;
            }
        }
        return Math.min(firstLow, secondLow) * 10 + Math.max(firstLow, secondLow);
    }

    private boolean[] getFound(int[] nums) {
        boolean[] found = new boolean[10];
        for (int num : nums) {
            found[num] = true;
        }
        return found;
    }
}
