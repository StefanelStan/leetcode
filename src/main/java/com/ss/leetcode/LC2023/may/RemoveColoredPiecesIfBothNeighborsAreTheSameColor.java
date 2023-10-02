package com.ss.leetcode.LC2023.may;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    // https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color
    /** Algorithm
        1. Looking at the problem, we understand that the winner is the one how cannot do any more movements.
            If Alice can make 3 movements and Bob only 2, then Alice wins.
            If Alice can make 3 movements and Bob can make 3 OR MORE, then Alice looses.
        2. Alice/Bob can only extract 1 piece if there are at least 3 consecutive pieces.
            EG: AABBBBBA => Bob can extract 3 times as he has a segment of 5 consecutive Bs:
        3. Traverse the string and count the length of each consecutive A/B segment.
            If current segment A has a length of 3, then Alice can make 1 extra move. If segment has length 4, alice can make 2 moves.
        4. With each consecutive segment that has more than 2 letters, Alice or Bob can do one extra movement.
        5. Count the length of each segment and determine the number of moves A and B can make.
        6. Alice can win only if she can make more moves then Bob.
     */
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0, bobMoves = 0;
        int aSegment = 0, bSegment = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                bSegment = 0;
                aSegment++;
                aliceMoves += aSegment > 2 ? 1 : 0;
            } else {
                aSegment = 0;
                bSegment++;
                bobMoves += bSegment > 2 ? 1 : 0;
            }
        }
        return aliceMoves > bobMoves;
    }
}
