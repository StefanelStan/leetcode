package com.ss.leetcode.LC2023.april;

public class RowWithMaximumOnes {
    // https://leetcode.com/problems/row-with-maximum-ones
    /** Algorithm
        1. Use an rowAndMaximumOnes[index,count] to keep track of the row with max 1s and max count of 1s.
        2. Traverse each row and count the 1s. If the current 1s is > rowAndMaxOnes[1], then replace
            the values with the current row and current count.
        3. Return rowAndMaximumOnes[]
     */
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] rowAndMaxOnes = {0,0};
        int oneCount;
        for (int i = 0; i < mat.length; i++) {
            oneCount = 0;
            for (int nr : mat[i]) {
                oneCount += nr;
            }
            if (oneCount > rowAndMaxOnes[1]) {
                rowAndMaxOnes[0] = i;
                rowAndMaxOnes[1] = oneCount;
            }
        }
        return rowAndMaxOnes;
    }
}
