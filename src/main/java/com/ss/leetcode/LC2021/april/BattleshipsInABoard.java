package com.ss.leetcode.LC2021.april;

public class BattleshipsInABoard {
    // https://leetcode.com/problems/battleships-in-a-board/
    public int countBattleships(char[][] board) {
        int battleships = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && !isAShipContinuation(board, i, j)) {
                    battleships++;
                }
            }
        }
        return battleships;
    }

    private boolean isAShipContinuation(char[][] board, int i, int j) {
        if (i == 0 && j == 0) {
            return false;
        }
        if (i == 0) {
            return board[i][j - 1] == 'X';
        } else if (j == 0) {
            return board[i - 1][j] == 'X';
        } else {
            return board[i][j - 1] == 'X' || board[i - 1][j] == 'X';
        }
    }
}
