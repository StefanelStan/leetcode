package com.ss.leetcode.LC2023.june;

public class CountArtifactsThatCanBeExtracted {
    // https://leetcode.com/problems/count-artifacts-that-can-be-extracted
    /** Algorithm
        1. Use a boolean[n][n] to mark which sites have been excavated
        2. For each artefact, check if each block between [x1,y1] -> [x2,y2] has been excavated.
        3. If the whole artefact is excavated, increment by 1.
     */
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] digged = getDiggedLocations(n, dig);
        int diggedArtefacts = 0;
        for(int[] artefact : artifacts) {
            diggedArtefacts += canBeDigged(digged, artefact) ? 1 : 0;
        }
        return diggedArtefacts;
    }

    private boolean canBeDigged(boolean[][] digged, int[] artefact) {
        for (int i = artefact[0]; i <= artefact[2]; i++) {
            for (int j = artefact[1]; j <= artefact[3]; j++) {
                if (!digged[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean[][] getDiggedLocations(int n, int[][] dig) {
        boolean[][] digged = new boolean[n][n];
        for (int[] site: dig) {
            digged[site[0]][site[1]] = true;
        }
        return digged;
    }
}
