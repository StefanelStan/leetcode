package com.ss.leetcode.LC2021.september;

public class SpecialPositionsInABinaryMatrix {
    // https://leetcode.com/problems/special-positions-in-a-binary-matrix/
    public int numSpecial(int[][] mat) {
        int special = 0;
        for (int[] line : mat) {
            if (isGoodLine(line, mat)) {
                special++;
            }
        }
        return special;
    }

    private boolean isGoodLine(int[] line, int[][] mat) {
        int pos = -1;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 1) {
                if (pos != -1) {
                    return false;
                }
                pos = i;
            }
        }
        if (pos == -1) {
            return false;
        }
        boolean colFound = false;
        for (int[] ints : mat) {
            if (ints[pos] == 1) {
                if (colFound) {
                    return false;
                }
                colFound = true;
            }
        }
        return true;
    }
}
