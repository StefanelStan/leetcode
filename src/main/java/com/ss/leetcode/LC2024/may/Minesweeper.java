package com.ss.leetcode.LC2024.may;

public class Minesweeper {
    // https://leetcode.com/problems/minesweeper
    /** Algorithm
        1. Fail fast: if given cell is M, set it to X and return the board
        2. Else, apply DFS and use a recursive method to visit and mark each cell, starting from the clicked cell
           Use an int[][] DIRECTIONS to mark the x/y diffs for all 8 directions
            - if given cell is NOT E, return from the method (only interested in empty cells)
            - else, count the "bombs" around the given empty cell from all 8 directions
            - if count is 0, mark the cell with B (blank) and try to color/mark all 8 nearby cells
            - if count is > 0, put that number but DO NOT color any nearby cell, as this would not propagate the marking dfs
     */
    private static final int[][] DIRECTIONS = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            processCell(board, click[0], click[1]);
        }
        return board;
    }

    private void processCell(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || board[x][y] != 'E') {
            return;
        }
        int count = 0;
        for (int[] direction : DIRECTIONS) {
            count += countMine(board, x + direction[0], y + direction[1]);
        }
        if (count == 0) {
            board[x][y] = 'B';
            for (int[] direction : DIRECTIONS) {
                processCell(board, x + direction[0], y + direction[1]);
            }
        } else {
            board[x][y] = (char)(count + '0');
        }
    }

    private int countMine(char[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length && (board[x][y] == 'M' || board[x][y] == 'X') ? 1 : 0;
    }
}
