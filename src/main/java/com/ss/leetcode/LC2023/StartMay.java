package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.may.ContainsDuplicateIII;
import com.ss.leetcode.LC2023.may.MatrixBlockSum;
import com.ss.leetcode.LC2023.may.RemoveColoredPiecesIfBothNeighborsAreTheSameColor;
import java.util.Arrays;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.matrixBlockSum();
//        start.removeColoredPiecesIfBothNeighborsAreTheSameColor();
        start.containsDuplicateIII();
    }

    public void matrixBlockSum() {
        MatrixBlockSum mbs = new MatrixBlockSum();

        System.out.println("[[12,21,16],[27,45,33],[24,39,28]] == " + Arrays.deepToString(mbs.matrixBlockSum(
            new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1)));

        System.out.println("[[45,45,45],[45,45,45],[45,45,45]] == " + Arrays.deepToString(mbs.matrixBlockSum(
            new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 2)));
    }

    public void removeColoredPiecesIfBothNeighborsAreTheSameColor() {
        RemoveColoredPiecesIfBothNeighborsAreTheSameColor rcpibnatsc = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor();

        System.out.println("true == " + rcpibnatsc.winnerOfGame("AAABABB"));
        System.out.println("false == " + rcpibnatsc.winnerOfGame("AA"));
        System.out.println("false == " + rcpibnatsc.winnerOfGame("ABBBBBBBAAA"));
        System.out.println("false == " + rcpibnatsc.winnerOfGame("AAAABBBB"));
    }

    public void containsDuplicateIII() {
        ContainsDuplicateIII cdiii = new ContainsDuplicateIII();

        System.out.println("true == " + cdiii.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println("false == " + cdiii.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println("false == " + cdiii.containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4));
    }
}
