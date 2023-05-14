package com.ss.leetcode.LC2023.may;

public class DiagonalTraverse {
    // https://leetcode.com/problems/diagonal-traverse
    /** Algorithm: Look at the problem as made out of two problems:
        A: Adding elements from LEFT OF and including main Diagonal
            - Row i is always[0] and column j goes from 0 to M-1.
        B: Adding elements from RIGHT of main diagonal (without including it)
            - Row goes from i = 1..N-1 but your column j stays M-1.
        A: Adding elements into [] traversal.
        1. When traversing down, we can add the elements in their normal way in traversal[]:
            EG: supposing your are on row[0] and j[1]: the elements as we go down are 3,2,1,5.
            As we go down, we insert them in a normal way in traversal: [x, 3,2,1,5]
        2. When traversing up, actually we insert them in reverse order.
            EG: supposing going up, the elements in diagonal are (from bottom tp up) 3,2,1,5 (3 is at row[3] and 5 at row[0]).
            our traversal is at index[10]. We know we have to add 4 elements. So we jump the insert index to 13.
        Then traversing normally, (row+1, col-1), we insert 5 at traversal[13], 1 at traversal[12], 2 at traversal[11] and 3 at traversal[10]. (the index travels backwards).
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int[] traversal = new int[mat.length * mat[0].length];
        boolean goingUp = true;
        int insert = 0;
        for (int j = 0; j < mat[0].length; j++) {
            insert = insertTraversal(0, j, mat, insert, traversal, goingUp) + 1;
            goingUp = !goingUp;
        }
        for (int i = 1; i < mat.length && insert <= traversal.length - 1; i++) {
            insert = insertTraversal(i, mat[0].length -1, mat, insert, traversal, goingUp) + 1;
            goingUp = !goingUp;
        }
        return traversal;
    }

    private int insertTraversal(int row, int col, int[][] mat, int idx, int[] traversal, boolean goingUp) {
        int distance = Math.min(mat.length - 1 - row, col);
        int insertStartingPoint = goingUp? idx + distance : idx;
        while (col >= 0 && row < mat.length) {
            traversal[insertStartingPoint] = mat[row++][col--];
            insertStartingPoint += goingUp? -1 : 1;
        }
        return idx + distance;
    }
}
