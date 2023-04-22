package com.ss.leetcode.LC2023.april;

public class MinimumOperationsToMakeAUniValueGrid {
    // https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid
    /** Algorithm
        1. Observe the examples
            - EG1: 1,10,19, 28 x = 3. We can make all of them equal in 12 steps (all equal to 10).
            - EG2: 1, 10, 19,28 x = 9. We can make all of them equal to 10 in 4 steps;
            - EG3: 1,10,19, 28 x = 2. We CANNOT make them equal between
        2. The trick is that ALL numbers must have the same modulo % x.
            - [1,10,19, 28] x = 3. All numbers % 3 have modulo 1. Same for  [1, 10, 19,28] x = 9
             - [1,10,19, 28] x = 2. [1 and 19] % 2 = 1 and [10,28] % 2 = 0. They have different modulo so they cannot be made equal
        3. Traverse the matrix and check for their modulo. If the modulo is different, return -1 immediately.
        4. As a hyper optimization, we need to know what numbers we have, their count (how many of each) and their prefixSum.
            Supposing we have this matrix [1,1,1,1,3,3,5,5,5,9,7,9,7,7,7,7] x = 2
            in an int[3][number_of_unique_numbers] count and store this information
            [1,  3,  5,  7,  9] - what numbers you have
            [4,  6,  9, 14, 16] - their prefix count. How many numbers greater than 5 you got? 16 - 9 = 7.
            [4, 10, 25, 60, 78] - prefix Sum: number[i] * count[i].
        5. This table will allow to quickly compute how many steps are needed to make (to raise) ALL number left of i to i
            and (lower) ALL numbers right of i to match i.
            EG: Let's look at number 7.
            LEFT:
                9 numbers on left of 7. 9*7 = 63. They should be raised to sum of 63.
                their sum if 25. So 63 - 25 = 38. 38 / 2 = 19 steps.
            RIGHT:
                16-14 = 2 numbers at the right of 7. Their sum is (78-60) = 18.
                As they are greater than 7, their sum will need to be lowed to 7 * 2 = 14.
                18 - 14 = 4. 4 / 2 (x) = 2.
            So to raise ALL numbers lesser than 7 to 7 we need 19 steps. To lower all numbers greater than 7 we need 2 steps.
            Total is 21.
        6. Apply step 5 for all group numbers
     */

    public int minOperations(int[][] grid, int x) {
        int[][] count = getCountAndPrefixNumbers(grid, x);
        if (count == null) {
            return -1;
        }
        int minOps = Integer.MAX_VALUE;
        int opsOnLeft, opsOnRight;
        int n = count[0].length - 1;
        for (int i = 1; i <= n; i++) {
            opsOnLeft = (count[0][i] * count[1][i-1] - count[2][i-1]) / x;
            opsOnRight = (count[2][n] - count[2][i] - (count[0][i] * (count[1][n] - count[1][i]))) / x;
            minOps = Math.min(minOps, opsOnLeft + opsOnRight);
        }

        return minOps;
    }

    private int[][] getCountAndPrefixNumbers(int[][] grid, int x) {
        int unique = 0;
        int expectedMod = grid[0][0] % x;
        int[] count = new int[10001];
        for (int[] row : grid) {
            for (int nr: row) {
                if (nr % x != expectedMod) {
                    return null;
                }
                if (++count[nr] == 1) {
                    unique++;
                }
            }
        }
        int[][] countAndPrefix = new int[3][unique + 1];
        int insertIndex = 1;
        for (int i = 0; i < count.length && unique > 0; i++) {
            if (count[i] > 0) {
                countAndPrefix[0][insertIndex] = i;
                countAndPrefix[1][insertIndex] = countAndPrefix[1][insertIndex - 1] + count[i];
                countAndPrefix[2][insertIndex] = countAndPrefix[2][insertIndex - 1] + count[i] * i;
                insertIndex++;
                unique--;
            }
        }
        return countAndPrefix;
    }
}
