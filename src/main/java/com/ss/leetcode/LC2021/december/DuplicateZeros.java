package com.ss.leetcode.LC2021.december;

public class DuplicateZeros {
    // https://leetcode.com/problems/duplicate-zeros/
    /** Algorithm :
     *  1. Create a new array (shifted[]) of the same Size. The correct elements from arr[] will be copied to shifted[]
     *  2. Loop with 2 indexes: i over arr and j over shifted[].
     *     - If arr[i] is != 0, copy it to shifted[j]. Increment i and j
     *     - If arr[i] == 0, increment i by 1 and j by 2 as shifted[j,j+1] are already 0.
     *     - Incrementing by 2 will simulate the insertion of a 0 in shifted
     */
    public void duplicateZeros(int[] arr) {
        int[] shifted = new int[arr.length];
        for (int i = 0, j = 0; i < arr.length && j < arr.length; i++) {
            if (arr[i] != 0) {
                shifted[j++] = arr[i];
            } else {
                j += 2;
            }
        }
        System.arraycopy(shifted, 0, arr, 0, arr.length);
    }
}
