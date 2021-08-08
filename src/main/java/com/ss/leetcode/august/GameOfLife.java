package com.ss.leetcode.august;

public class GameOfLife {
    // https://leetcode.com/problems/game-of-life/
    public void gameOfLife(int[][] board) {
        NearbyCells[][] neighbours = new NearbyCells[board.length][board[0].length];
        // nearbyCells[0] = alive cells, nearbyCells[1] = dead cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                countNearbyCells(board, i, j, neighbours);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                changeState(board, i, j, neighbours);
            }
        }
    }

    private void changeState(int[][] board, int i, int j, NearbyCells[][] neighbours) {
        if (board[i][j] == 1) {
            if (neighbours[i][j].aliveCells < 2) {
                board[i][j] = 0;
            } else if (neighbours[i][j].aliveCells <= 3) {
                board[i][j] = 1;
            } else {
                board[i][j] = 0;
            }
        } else if (neighbours[i][j].aliveCells == 3) {
            board[i][j] = 1;
        }
    }

    private void countNearbyCells(int[][] board, int i, int j, NearbyCells[][] nearbyCells) {
        nearbyCells[i][j] = new NearbyCells();
        countUpperLevel(board, i, j, nearbyCells);
        countMidLevel(board, i, j, nearbyCells);
        countLowerLevel(board, i, j, nearbyCells);
    }

    private void countUpperLevel(int[][] board, int i, int j, NearbyCells[][] nearbyCells) {
        if (i > 0) {
            for (int k = (Math.max(0, j - 1)); k <= Math.min(j + 1, board[i].length - 1); k++) {
                if (board[i - 1][k] == 0) {
                    nearbyCells[i][j].deadCells++;
                } else {
                    nearbyCells[i][j].aliveCells++;
                }
            }
        }
    }

    private void countMidLevel(int[][] board, int i, int j, NearbyCells[][] nearbyCells) {
        if (j > 0) {
            if (board[i][j - 1] == 0) {
                nearbyCells[i][j].deadCells++;
            } else {
                nearbyCells[i][j].aliveCells++;
            }
        }
        if (j < board[i].length - 1) {
            if (board[i][j + 1] == 0) {
                nearbyCells[i][j].deadCells++;
            } else {
                nearbyCells[i][j].aliveCells++;
            }
        }
    }

    private void countLowerLevel(int[][] board, int i, int j, NearbyCells[][] nearbyCells) {
        if (i < board.length - 1) {
            for (int k = (Math.max(0, j - 1)); k <= Math.min(j + 1, board[i].length - 1); k++) {
                if (board[i + 1][k] == 0) {
                    nearbyCells[i][j].deadCells++;
                } else {
                    nearbyCells[i][j].aliveCells++;
                }
            }
        }
    }

    static class NearbyCells {
        int aliveCells;
        int deadCells;

    }
}
