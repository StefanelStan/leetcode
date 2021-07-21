package com.ss.leetcode.july;

import java.util.Arrays;

public class PushDominoes {
    // https://leetcode.com/problems/push-dominoes/
    private static final char DOT = '.';
    private static final char RIGHT = 'R';
    private static final char LEFT = 'L';

    public String pushDominoes(String dominoes) {
        final char[] pieces = dominoes.toCharArray();

        int endOfSequence = 0;
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] == DOT) {
                endOfSequence = getEndOfSequence(pieces, i);
                moveDominoes(pieces, i, endOfSequence);
                i = endOfSequence;
            }
        }
        return new String(pieces);
    }

    private int getEndOfSequence(char[] pieces, int from) {
        for (int i = from + 1; i < pieces.length; i++) {
            if (pieces[i] != DOT) {
                return i;
            }
        }
        return pieces.length - 1;
    }


    private void moveDominoes(char[] pieces, int fromIndex, int toIndex) {
        if (fromIndex > 0) fromIndex = fromIndex -1;
        int difference = toIndex - fromIndex - 1;
        if (pieces[fromIndex] == DOT && pieces[toIndex] == LEFT) {
            Arrays.fill(pieces, fromIndex, toIndex, LEFT);
        } else if (pieces[toIndex] == DOT && pieces[fromIndex] == RIGHT) {
            Arrays.fill(pieces, fromIndex + 1, toIndex + 1, RIGHT);
        } else if (pieces[fromIndex] == pieces[toIndex] && pieces[fromIndex] != DOT) {
            Arrays.fill(pieces, fromIndex, toIndex, pieces[fromIndex]);
        } else if (pieces[fromIndex] == RIGHT && pieces[toIndex] == LEFT && difference > 1) {
            Arrays.fill(pieces, fromIndex + 1, fromIndex + difference / 2 + 1, RIGHT);
            Arrays.fill(pieces, fromIndex + (difference % 2 == 0 ? 1 : 2) + difference / 2, toIndex, LEFT);
        }
    }
}
