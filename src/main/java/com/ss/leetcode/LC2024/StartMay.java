package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.may.KthSmallestPrimeFraction;
import com.ss.leetcode.LC2024.may.LongestStrictlyIncreasingOrStrictlyDecreasingSubarray;
import com.ss.leetcode.LC2024.may.MatrixSimilarityAfterCyclicShifts;
import com.ss.leetcode.LC2024.may.MaximizeHappinessOfSelectedChildren;
import com.ss.leetcode.LC2024.may.MaximumNumberOfGroupsEnteringACompetition;
import com.ss.leetcode.LC2024.may.Minesweeper;
import java.util.Arrays;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.maximumNumberOfGroupsEnteringACompetition();
//        start.minesweeper();
//        start.maximizeHappinessOfSelectedChildren();
//        start.kthSmallestPrimeFraction();
//        start.matrixSimilarityAfterCyclicShifts();
        start.longestStrictlyIncreasingOrStrictlyDecreasingSubarray();
    }

    public void maximumNumberOfGroupsEnteringACompetition() {
        MaximumNumberOfGroupsEnteringACompetition mnogeac = new MaximumNumberOfGroupsEnteringACompetition();

        System.out.println("3 == " + mnogeac.maximumGroups(new int[]{10,6,12,7,3,5}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{8,8}));
        System.out.println("8 == " + mnogeac.maximumGroups(new int[]{4,3,2,3,43,5,56,76,78,8,7,6,56,5,34,23,34,4,5,6,7,88,7,6,5,45,3,3,76,4,5,6,7,8,87,7,6,5,4,3,4,5,6}));
        System.out.println("3 == " + mnogeac.maximumGroups(new int[]{1,1,1,1,1,1,1,1,1}));
        System.out.println("6 == " + mnogeac.maximumGroups(new int[]{1,6,5,4,3,2,3,4,5,4,3,1,2,3,4,2,100,1000,10000,20000,30000}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{1}));
        System.out.println("1 == " + mnogeac.maximumGroups(new int[]{7}));
    }

    public void minesweeper() {
        Minesweeper m = new Minesweeper();

        System.out.println("[[B,1,E,1,B],[B,1,M,1,B],[B,1,1,1,B],[B,B,B,B,B]] == " + Arrays.deepToString(m.updateBoard(new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}}, new int[]{3,0})));
        System.out.println("[[B,1,E,1,B],[B,1,X,1,B],[B,1,1,1,B],[B,B,B,B,B]] == " + Arrays.deepToString(m.updateBoard(new char[][]{{'B','1','E','1','B'},{'B','1','M','1','B'},{'B','1','1','1','B'},{'B','B','B','B','B'}}, new int[]{3,0})));
    }

    public void maximizeHappinessOfSelectedChildren() {
        MaximizeHappinessOfSelectedChildren mhosc = new MaximizeHappinessOfSelectedChildren();

        System.out.println("4 == " + mhosc.maximumHappinessSum(new int[]{1,2,3}, 2));
        System.out.println("1 == " + mhosc.maximumHappinessSum(new int[]{1,1,1,1}, 2));
        System.out.println("5 == " + mhosc.maximumHappinessSum(new int[]{2,3,4,5}, 1));
    }

    public void kthSmallestPrimeFraction() {
        KthSmallestPrimeFraction kspf = new KthSmallestPrimeFraction();

        System.out.println("[2,5] == " + Arrays.toString(kspf.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3)));
        System.out.println("[1,7] == " + Arrays.toString(kspf.kthSmallestPrimeFraction(new int[]{1,7}, 1)));
    }

    public void matrixSimilarityAfterCyclicShifts() {
        MatrixSimilarityAfterCyclicShifts msacs = new MatrixSimilarityAfterCyclicShifts();

        System.out.println("true == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 2));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{2,2},{2,2}}, 3));
        System.out.println("false == " + msacs.areSimilar(new int[][]{{1,2}}, 1));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 24));
        System.out.println("false == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 49));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 50));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{4}}, 37));
        System.out.println("true == " + msacs.areSimilar(new int[][]{{5},{3},{2}}, 14));
    }

    public void longestStrictlyIncreasingOrStrictlyDecreasingSubarray() {
        LongestStrictlyIncreasingOrStrictlyDecreasingSubarray lsiosds = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray();

        System.out.println("2 == " + lsiosds.longestMonotonicSubarray(new int[]{1,4,3,3,2}));
        System.out.println("1 == " + lsiosds.longestMonotonicSubarray(new int[]{3,3,3,3}));
        System.out.println("3 == " + lsiosds.longestMonotonicSubarray(new int[]{3,2,1}));
        System.out.println("5 == " + lsiosds.longestMonotonicSubarray(new int[]{1,2,3,4,3,2,3,4,5,6,5,34,3,5,6,34,2,43,46,5,43,44,32,48,5,34,45,24,5,43,45,23,45,4,34,45,5,34,6,15,6,47}));
        System.out.println("1 == " + lsiosds.longestMonotonicSubarray(new int[]{5}));
    }
}
