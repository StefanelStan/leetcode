package com.ss.leetcode.LC2023.february;

import java.util.Arrays;

public class MergeTwo2DArraysBySummingValues {
    // https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values
    /** Algorithm
        1. Use two pointers i and j to traverse nums1, nums2 and an int[][] answer of size nums1+nums2
        2. While i <nums1.length and j < nums.length
            - if nums1[i] == nums2[j] then insert the merged value into array
            - if nums1[i] < nums2[j] , then isert nums1[i] and advance i (i++)
            - else insert nums2[j] and advance j
        3. This while stops when i OR j reach the end of nums1 or nums2. Both of them could reach at the same time.
            From this point you need to check which array still has numbers to add (i or j)
        4. If i or j has not reached the end of nums1 or nums2, determine which array still has elements to add.
        5. Loop from the remaining index till the end to add the remaining elements in the answer.
        6. Return a trimmed version of answer (according to its true final length)
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        int[][] answer = new int[nums1.length + nums2.length][2];
        int insertIndex = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                answer[insertIndex][0] = nums1[i][0];
                answer[insertIndex][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                answer[insertIndex][0] = nums1[i][0];
                answer[insertIndex][1] = nums1[i][1];
                i++;
            } else {
                answer[insertIndex][0] = nums2[j][0];
                answer[insertIndex][1] = nums2[j][1];
                j++;
            }
            insertIndex++;
        }

        if (i != nums1.length || j != nums2.length) {
            int[][] remainingArray = i == nums1.length ? nums2 : nums1;
            int k = remainingArray == nums1 ? i : j;
            while(k < remainingArray.length) {
                answer[insertIndex][0] = remainingArray[k][0];
                answer[insertIndex++][1] = remainingArray[k++][1];
            }
        }
        return Arrays.copyOf(answer, insertIndex);
    }
}
