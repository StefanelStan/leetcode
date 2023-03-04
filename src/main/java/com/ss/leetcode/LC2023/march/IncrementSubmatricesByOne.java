package com.ss.leetcode.LC2023.march;

public class IncrementSubmatricesByOne {
    // https://leetcode.com/problems/increment-submatrices-by-one
    /** Algorithm
        1. Declare an int[][] markings that will contain the marking of increment/decrement, but will
            also contain the answer to the problem
        2. For each query, mark the rows query[0]..query[2] column query[1] with +1 and query[3]+1 with  -1.
        3. Following step 2, traverse each row and use a rollingSum to add the value of the marking.
            Set cell value to the value of the rollingValue.
        4. When a cell will have a marking of -1, then the rollingValue will decrease and the following cells on that row
            will have value 0.
            EG: supposing row[x] is [0,0,0,1,0,0,-1,0]
            - when traversing it, as soon as we hit index 3, the rollingSum becomes 1. The ongoing cells will have the value 1.
            - when hitting index 6, the rolling sum becomes 0 (1-1) so the folling cells will have value 0.
     */
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] markings = getMarkingMatrix(n, queries);
        int rollingValue;
        for (int i = 0; i < n; i++) {
            rollingValue = 0;
            for(int j = 0; j < n; j++) {
                rollingValue += markings[i][j];
                markings[i][j] = rollingValue;
            }
        }
        return markings;
    }

    private int[][] getMarkingMatrix(int n, int[][] queries) {
        int[][] markings = new int[n][n];
        for (int[] query : queries) {
            for(int i = query[0]; i <= query[2]; i++) {
                markings[i][query[1]]++;
                if(query[3] < n-1) {
                    markings[i][query[3]+1]--;
                }
            }
        }
        return markings;
    }
}
