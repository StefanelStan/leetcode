package com.ss.leetcode.november;

public class UniqueBinarySearchTrees {
    // https://leetcode.com/problems/unique-binary-search-trees/
    public int numTrees(int n) {
        int[] nrOfTrees = new int[20];
        nrOfTrees[0] = 1;
        nrOfTrees[1] = 1;
        getNumberOfTrees(n, nrOfTrees);
        return nrOfTrees[n];
    }

    private int getNumberOfTrees(int n, int[] nrOfTrees) {
        if (n == 0 || n == 1) {
            return nrOfTrees[n];
        }
        if (nrOfTrees[n] != 0) {
            return nrOfTrees[n];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getNumberOfTrees(i-1, nrOfTrees) * getNumberOfTrees(n-i, nrOfTrees);
        }
        nrOfTrees[n] = count;
        return count;
    }
}
