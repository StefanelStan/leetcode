package com.ss.leetcode.LC2023.september;

public class MaximumNonNegativeProductInAMatrix {
    // https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix
    /** Algorithm
        1. Looking at the way we traverse the matrix, (move right or down), each element [i][j] would need to make
            an educated selection between the best product path coming from left OR up.
        2. However, at the moment of selection, we do not know which is the best to choose: a positive or negative.
            EG: if grid[m][n] is negative, then it's best to select the MAX negative product you can find along the way which, in turn, will become positive.
        3. Thus, EACH position[i][j] will have to store, compute and pass alongside the BEST/ positive and negative product is has ever encountered.
            EG: [[-1,2,0],[-4,4,3]].
            at index [1][1] we see that we have two options: path from left and path from above
            - path from left produces -1 * -4 = 4.
            - path from above produces -1 * 2 = -2.
            index[1,1] is 4. So we have two products: a positive 4 * 4 (16) and a negative one (4 * -2 = -8).
            At this time, we cannot know which will be the best choice, as we don't know how many negative numbers we might have below,
            so we propagate both of them: bestPositive and bestNegative.
        4. Use a matrix SignedProduct[][] (positive, negative) to store the best values you can pass along the path.
        5. For each step [1..m][1..n] try to determine the best positive / negative products that can be formed using current grid[i][j] and signedProduct[left]/[up]
            - Edge cases:
            - If both options (best positive/negative) are positive, then pass the max of them as positive
            - if both options are negative, pass the min of them: (-5, -2) => -5 will have better chance of turning into a higher positive product
            - else pass min/max (min negative, max positive)
     */
    private static final int MODULO = 1_000_000_007;
    public int maxProductPath(int[][] grid) {
        SignedProduct[][] products = initSignedProducts(grid);
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                products[i][j] = getBestSignedProduct(grid[i][j], products[i-1][j], products[i][j-1]);
            }
        }
        return Math.max(-1, (int)(products[grid.length -1][grid[0].length -1].positive % MODULO));
    }

    private SignedProduct getBestSignedProduct(int val, SignedProduct up, SignedProduct left) {
        long minNegative = Long.MAX_VALUE, maxPositive = Long.MIN_VALUE;
        long[] candidates = new long[4];
        candidates[0] = up.positive * val;
        candidates[1] = up.negative * val;
        candidates[2] = left.positive * val;
        candidates[3] = left.negative * val;
        for (int i = 0; i < 4; i++) {
            minNegative = Math.min(minNegative, candidates[i]);
            maxPositive = Math.max(maxPositive, candidates[i]);
        }
        if (maxPositive < 0) {
            return new SignedProduct(minNegative, minNegative);
        } else if (minNegative > 0) {
            return new SignedProduct(maxPositive, maxPositive);
        } else {
            return new SignedProduct(maxPositive, minNegative);
        }
    }

    private SignedProduct[][] initSignedProducts(int[][] grid) {
        SignedProduct[][] products = new SignedProduct[grid.length][grid[0].length];
        int rollingProduct = grid[0][0];
        products[0][0] = new SignedProduct(rollingProduct, rollingProduct);
        for (int j = 1; j < grid[0].length; j++) {
            rollingProduct *= grid[0][j];
            products[0][j] = new SignedProduct(rollingProduct, rollingProduct);
        }
        rollingProduct = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            rollingProduct *= grid[i][0];
            products[i][0] = new SignedProduct(rollingProduct, rollingProduct);
        }
        return products;
    }

    private static class SignedProduct {
        long positive;
        long negative;

        public SignedProduct(long positive, long negative) {
            this.positive = positive;
            this.negative = negative;
        }
    }
}
