package com.ss.leetcode.LC2021.august;

public class BaseballGame {
    // https://leetcode.com/problems/baseball-game/
    public int calPoints(String[] ops) {
        int[] scoreBoard = new int[ops.length];
        int boardIndex = 0;
        for(String op : ops) {
            switch (op) {
                case "C" -> boardIndex--;
                case "D" -> {
                    scoreBoard[boardIndex] = 2 * scoreBoard[boardIndex - 1];
                    boardIndex++;
                }
                case "+" -> {
                    scoreBoard[boardIndex] = scoreBoard[boardIndex -1] + scoreBoard[boardIndex -2];
                    boardIndex++;
                }
                default -> scoreBoard[boardIndex++] = getValue(op);
            }
        }
        int sum = 0;
        for(int i = 0; i < boardIndex; i++) {
            sum += scoreBoard[i];
        }
        return sum;
    }

    private int getValue(String s) {
        int value = 0;
        int start = s.charAt(0) == '-' ? 1 : 0;
        while(start < s.length()) {
            value = value * 10 + (s.charAt(start++) - '0');
        }
        return s.charAt(0) == '-' ? -value : value;
    }


    public int calPoints2(String[] ops) {
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
