package com.ss.leetcode.LC2022.january;

import java.util.Arrays;

public class CheckArrayFormationThroughConcatenation {
    // https://leetcode.com/problems/check-array-formation-through-concatenation/
    /** Algorithm
     1. use an array[101] to store the positions of each int piece inside pieces array.
     eg: presentPieces[]. Initialize it with -1 first.
     2. Loop over pieces and save each piece/fragment position relative to pieces index
     eg: [[88],[15]] -> presentPieces[88] =0 and presentPieces[15]=0.
     Both numbers are located at position 0 in pieces
     3. - Loop over arr with i and check if each int has a position in presentPieces[] array.
     If not, return false immediately
     - If has a position, check that chunks'e length. If that piece/chunk length >1, traverse the chunk and arr[i]
     to check if the piece contains all 2..n consecutive elements of arr.
     - If not, return false;
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] presentPieces = new int[101];
        Arrays.fill(presentPieces, -1);
        for(int i = 0; i < pieces.length; i++) {
            for (int piece: pieces[i]) {
                presentPieces[piece] = i;
            }
        }
        int pos;
        for (int i = 0; i < arr.length;) {
            pos = presentPieces[arr[i]];
            // if arr[i] is not present, return false
            if (pos == -1) {
                return false;
            } else {
                // if arr[i] is present in a piece and if that piece has more elements, check each element of piece
                if (pieces[pos].length > 1) {
                    for (int piece : pieces[pos]) {
                        if (arr[i] == piece) {
                            i++;
                        } else {
                            // if one element of that piece is not == arr[i], return false immediately
                            return false;
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        return true;
    }
}
