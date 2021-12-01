package com.ss.leetcode.LC2021.august;

public class BaseballGame {
    // https://leetcode.com/problems/baseball-game/
    public int calPoints(String[] ops) {
        int[] board = new int[ops.length];
        int boardIndex = 0;
        for (String op : ops) {
            switch (op.charAt(0)) {
                case 'C' -> boardIndex--;
                case 'D' -> {
                    board[boardIndex] = 2 * board[boardIndex - 1];
                    boardIndex++;
                }
                case '+' -> {
                    board[boardIndex] = board[boardIndex - 1] + board[boardIndex - 2];
                    boardIndex++;
                }
                default -> board[boardIndex++] = Integer.parseInt(op);
            }
        }

        int sum = 0;
        for (int i = 0; i < boardIndex; i++) {
            sum += board[i];
        }
        return sum;
    }
}
