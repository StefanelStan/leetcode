package com.ss.leetcode.LC2022.august;

import java.util.Arrays;

public class CountVowelsPermutation {
    // https://leetcode.com/problems/count-vowels-permutation/
    /** Algorithm
         1. Look at the table of vowels combinations: a can only be followed by e,
             e may only be followed by a or i.
             Thus, all the 2-letter words starting with a can only be [ae].
             All the 2-letter words starting with e can only be [ea] and [ei].
         2. Looking in advance, all 10-letter words starting with e can only be
             [ea...8_letters] and [ei.._8_letters].
             So, all 10-letter words starting with e will have a length equal to the sum
             of all 9 letters starting with a + all 9 letters starting with i.
         3. Based on this fact, let's build our permutations from 1 to n.
         4. Declare a matrix permutations[n][5], each row representing permutations of length i and
         5 - the number of columns (a,e,i,o,u)
         5. First row (permutations[0] will have 1 on each column, as you can only have 1 single letter
         6. Starting from row = 1 to n-1, apply the set of rules on each column
             (replace a,e,i,o,u with 0,1,2,3,4. Using letters just to point the idea)
             permutations[row][a] = permutations[row-1][e]
             permutations[row][e] = permutations[row-1][a] + permutations[row-1][i]
             ...
             permutations[row][u] = permutations[row][a]
         7. The answer if the sum of all permutations of row n-1.
     */
    private static final int[][] allowedCombinations = new int[][]{{1},{0,2},{0,1,3,4},{2,4},{0}};
    public int countVowelPermutation(int n) {
        int[][] combinationCount = new int[5][n];
        combinationCount[0][n-1] = combinationCount[1][n-1] = combinationCount[2][n-1] = combinationCount[3][n-1] = combinationCount[4][n-1] = 1;
        for (int j = n-2; j >= 0; j--) {
            for (int i = 0; i < 5; i++) {
                combinationCount[i][j] = sumAllowedCombinations(combinationCount, j + 1, allowedCombinations[i]);
            }
        }
        return getSum(combinationCount);
    }

    private int sumAllowedCombinations(int[][] combinationCount, int j, int[] allowedIndices) {
        int sum = 0;
        for (int index : allowedIndices) {
            sum = (sum + combinationCount[index][j]) % 1_000_000_007;
        }
        return sum;
    }

    private int getSum(int[][] combinationCount) {
        int sum = 0;
        for (int[] ints : combinationCount) {
            sum = (sum + ints[0]) % 1_000_000_007;
        }
        return sum;
    }


    public int countVowelPermutation2(int n) {
        int[][] permutations = new int[n][5];
        Arrays.fill(permutations[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                permutations[i][j] = (int)(getPermutationsOf(permutations, i, j) % 1_000_000_007);
            }
        }
        long sum = 0;
        for (long p : permutations[n-1]) {
            sum += p;
        }
        return (int)(sum % 1_000_000_007);
    }

    private long getPermutationsOf(int[][] permutations, int i, int j) {
        long sum = 0;
        switch (j) {
            case 0 -> sum = permutations[i - 1][1];
            case 1 -> sum += (long) permutations[i - 1][0] + permutations[i - 1][2];
            case 2 -> sum +=
                (long) permutations[i - 1][0] + permutations[i - 1][1] + permutations[i - 1][3]
                    + permutations[i - 1][4];
            case 3 -> sum += (long) permutations[i - 1][2] + permutations[i - 1][4];
            case 4 -> sum = permutations[i - 1][0];
        }
        return sum;
    }
}
