package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.march.LargestMagicSquare;
import com.ss.leetcode.LC2024.march.MaximizeTheTopmostElementAfterKMoves;
import com.ss.leetcode.LC2024.march.MaximumOddBinaryNumber;
import com.ss.leetcode.LC2024.march.NumberOfWaysToSelectBuildings;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.maximumOddBinaryNumber();
//        start.largestMagicSquare();
//        start.numberOfWaysToSelectBuildings();
        start.maximizeTheTopmostElementAfterKMoves();
    }

    public void maximumOddBinaryNumber() {
        MaximumOddBinaryNumber mobn = new MaximumOddBinaryNumber();

        System.out.println("001 == " + mobn.maximumOddBinaryNumber("010"));
        System.out.println("1001 == " + mobn.maximumOddBinaryNumber("0101"));
        System.out.println("1 == " + mobn.maximumOddBinaryNumber("1"));
        System.out.println("01 == " + mobn.maximumOddBinaryNumber("01"));
    }

    public void largestMagicSquare() {
        LargestMagicSquare lms = new LargestMagicSquare();

        System.out.println("3 == " + lms.largestMagicSquare(new int[][]{{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}}));
        System.out.println("2 == " + lms.largestMagicSquare(new int[][]{{5,1,3,1},{9,3,3,1},{1,3,3,8}}));
        System.out.println("2 == " + lms.largestMagicSquare(new int[][]{{1,1},{1,1}}));
        System.out.println("1 == " + lms.largestMagicSquare(new int[][]{{1},{1}}));
        System.out.println("1 == " + lms.largestMagicSquare(new int[][]{{8,6,12,20,3,11,6,9,3,19,14,9,9},{9,19,6,9,11,4,14,7,7,3,17,6,6},{3,1,2,3,18,5,13,4,9,11,18,13,15},{16,11,19,18,16,19,15,19,7,6,15,20,9},{10,16,3,7,5,16,1,13,12,15,1,19,17},{16,17,14,19,13,10,11,15,18,6,3,4,17},{18,10,18,7,8,9,16,10,19,16,9,9,6},{13,13,1,13,18,9,2,12,1,19,11,15,11},{9,17,5,20,3,3,19,18,18,20,7,17,1},{1,6,14,3,5,2,6,4,19,2,11,4,8},{8,2,16,1,18,13,7,7,10,4,16,10,19}}));
    }

    public void numberOfWaysToSelectBuildings() {
        NumberOfWaysToSelectBuildings nowtsb = new NumberOfWaysToSelectBuildings();

        System.out.println("6 == " + nowtsb.numberOfWays("001101"));
        System.out.println("0 == " + nowtsb.numberOfWays("11100"));
    }

    public void maximizeTheTopmostElementAfterKMoves() {
        MaximizeTheTopmostElementAfterKMoves mtteakm = new MaximizeTheTopmostElementAfterKMoves();

        System.out.println("5 == " + mtteakm.maximumTop(new int[]{5,2,2,4,0,6}, 4));
        System.out.println("-1 == " + mtteakm.maximumTop(new int[]{2}, 1));
        System.out.println("2 == " + mtteakm.maximumTop(new int[]{3,2,1}, 1));
        System.out.println("7 == " + mtteakm.maximumTop(new int[]{7,8,9}, 0));
    }
}