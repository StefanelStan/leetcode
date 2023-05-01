package com.ss.leetcode.LC2023.may;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    // https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color
    /** Algorithm
        1. Fail Fast: if length() < 3, return false as Alice cannot do any move.
        2. Traverse the string and count how many groups of 3A or 3B you got.
        3. The one with more groups will win as he/she can do more moves.
        4. If both of them have same number (0,1,2) Alice will lose as Bob will do last move.
     */
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3) {
            return false;
        }
        int aCount = 0, bCount = 0;
        char prevPrev = colors.charAt(0), prev = colors.charAt(1), current;
        for (int i = 2; i < colors.length(); i++) {
            current = colors.charAt(i);
            if (prevPrev == prev && prev == current) {
                if (current == 'A') {
                    aCount++;
                } else {
                    bCount++;
                }
            }
            prevPrev = prev;
            prev = current;
        }
        return aCount - bCount > 0;
    }
}
