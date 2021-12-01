package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        char[][] clone = new char[board.length][board[0].length];
        boolean[][] visited = new boolean[board.length][board[0].length];
        cloneBoard(board, clone);
        flipRegions(board, clone, visited);
        cloneBoardWithReplace(clone, board);
    }

    private void cloneBoard(char[][] source, char[][] dest) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, dest[i], 0, source[i].length);
        }
    }

    private void cloneBoardWithReplace(char[][] source, char[][] dest) {
        for (int i = 0; i < source.length; i++) {
            for(int j = 0; j < source[i].length; j++) {
                dest[i][j] = source[i][j] == 'X' ? 'X' : 'O';
            }
        }
    }

    private void flipRegions(char[][] board, char[][] clone, boolean[][] visited) {
        for (int i = 1; i < board.length -1; i++) {
            for (int j = 1; j < board[i].length -1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    List<int[]> points = new ArrayList<>();
                    boolean[] isValid = {true};
                    searchForRegion(board, clone, visited, i, j, isValid, points);
                    if (isValid[0]) {
                        for (int[] point : points) {
                            clone[point[0]][point[1]] = 'X';
                        }
                    } else {
                        for (int[] point : points) {
                            clone[point[0]][point[1]] = 'B';
                        }
                    }
                }
            }
        }
    }

    private void searchForRegion(char[][] board, char[][] clone, boolean[][] visited, int x, int y, boolean[] isValid, List<int[]> points){
        if (board[x][y] == 'O' && !visited[x][y]) {
            visited[x][y] = true;
            if ((y == 1 && board[x][0] <= 'O') || (y == board[0].length -2 && board[x][y +1] <= 'O') ||
                (x == 1 && board[0][y] <= 'O') || (x == board.length -2 && board[x+1][y] <= 'O') ||
                hasInvalidNeighbour(clone, x, y)
            ) {
                isValid[0] = false;
            }
            points.add(new int[]{x,y});
            if(x > 0) searchForRegion(board, clone, visited, x-1, y, isValid, points);
            if (x < board.length -1) searchForRegion(board, clone, visited, x+1, y, isValid, points);
            if(y > 0) searchForRegion(board, clone, visited, x, y-1, isValid, points);
            if (y < board[x].length -1) searchForRegion(board, clone, visited, x, y+1, isValid, points);
        }
    }

    private boolean hasInvalidNeighbour(char[][] clone, int x, int y) {
        boolean answer = false;
        if (x > 0) {
            answer = clone[x - 1][y] == 'B';
        }
        if (x < clone.length -1) {
            answer = answer || clone[x+1][y] == 'B';
        }
        if (y > 0) {
            answer = answer || clone[x][y-1] == 'B';
        }
        if (y < clone[x].length -1) {
            answer = answer || clone[x][y+1] == 'B';
        }
        return  answer;
    }
}
