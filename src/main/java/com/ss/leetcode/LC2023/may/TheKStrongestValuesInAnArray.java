package com.ss.leetcode.LC2023.may;

import java.util.Arrays;

public class TheKStrongestValuesInAnArray {
    // https://leetcode.com/problems/the-k-strongest-values-in-an-array
    /** Algorithm
        1. Sort the numbers and determine the median arr[(length - 1) / 2]
        2. The numbers furthest from median will be amongst thew strongest: left extreme and right extreme
        3. Use 2 pointers (left = 0, right = length -1) and compare the two values. Add the strongest
             of two to the answer and advance left (left++) or right (right --)
        4. Do this until the answer array is full.
     */
    public int[] getStrongest(int[] arr, int k) {
        int[] strongest = new int[k];
        Arrays.sort(arr);
        int left = 0, right = arr.length -1;
        int median = arr[(arr.length - 1) / 2], insertIndex = 0;
        while (insertIndex < k) {
            if (arr[right] - median >= median - arr[left]) {
                strongest[insertIndex++] = arr[right--];
            } else {
                strongest[insertIndex++] = arr[left++];
            }
        }
        return strongest;
    }
}
