package com.ss.leetcode.LC2023.june;

public class SumOfMatrixAfterQueries {
    // https://leetcode.com/problems/sum-of-matrix-after-queries
    /** Algorithm
        1. As queries have priority, it makes sense to process the queries in reverse order.
        2. Use a 2 x boolean[n] to keep track of what rows or cold have been queried.
            Also count how many rows / cols have been queried
        3. When processing a query, select the query type: row or col. If it has not been process (boolean[]), mark and process it
        4. If a whole column get set a certain value, do you multiply n by value?
            No, we certain rows from that column might have been already pre-processed
            EG: n = 10,
            last query : col 4 value 5. => this means sum += 5 * 10 (10 rows)
            query -1: row 3 value 7= > we can't add 10 * 7 (70) to sum because on previous query we have updated column 4, which already overrode row 3.
            thus, we can only add 7 * 9 to sum (63).
            With each query, count the edited number of rows/cols as each modification will only have partial benefit (diminishing returns)
     */
    public long matrixSumQueries(int n, int[][] queries) {
        long sum = 0L;
        boolean[] modifiedRows = new boolean[n];
        boolean[] modifiedCols = new boolean[n];
        int touchedRows = 0, touchedCols = 0;
        int[] query;
        for (int i = queries.length -1; i >= 0; i--) {
            query = queries[i];
            if (query[0] == 0) {
                if (!modifiedRows[query[1]]) {
                    modifiedRows[query[1]] = true;
                    touchedRows++;
                    sum += ((long)query[2] * (n - touchedCols));
                }
            } else if (!modifiedCols[query[1]]) {
                modifiedCols[query[1]] = true;
                touchedCols++;
                sum += ((long)query[2] * (n - touchedRows));
            }
        }
        return sum;
    }
}
