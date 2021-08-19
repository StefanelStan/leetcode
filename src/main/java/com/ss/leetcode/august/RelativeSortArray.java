package com.ss.leetcode.august;

import java.util.Arrays;

public class RelativeSortArray {
    // https://leetcode.com/problems/relative-sort-array/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] sortedArray = new int[arr1.length];
        int[] counting = new int[1001];
        for(int num : arr1) {
            counting[num]++;
        }
        int fillingIndex = 0;
        for (int unique : arr2) {
            Arrays.fill(sortedArray, fillingIndex, fillingIndex + counting[unique], unique);
            fillingIndex += counting[unique];
            counting[unique] = 0;
        }
        for (int i = 0;i < counting.length; i++) {
            if (counting[i] > 0) {
                Arrays.fill(sortedArray, fillingIndex, fillingIndex + counting[i], i);
                fillingIndex += counting[i];
            }
        }
        return sortedArray;
    }
}
