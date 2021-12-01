package com.ss.leetcode.LC2021.august;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {
    // https://leetcode.com/problems/sudoku-solver/
    public void solveSudoku(char[][] board) {
        Map<Integer, Set<Integer>> squares = new HashMap<>();
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> columns = new HashMap<>();
        parseBoard(board, squares, rows, columns);
        solveBoard(board, squares, rows, columns);
    }

    private void parseBoard(char[][] board, Map<Integer, Set<Integer>> squares, Map<Integer, Set<Integer>> rows,
                            Map<Integer, Set<Integer>> columns) {
        putMissingNumbersIntoSquares(squares, board);
        putMissingNumberIntoRows(rows, board);
        putMissingNumbersIntoColumns(columns, board);
    }

    private void putMissingNumbersIntoSquares(Map<Integer, Set<Integer>> squares, char[][] board) {
        int squareNumber = 0;
        while (squareNumber < 9) {
            boolean[] presentDigits = new boolean[9];
            int startingRow = (squareNumber - squareNumber % 3);
            int startingColumn = (squareNumber % 3) * 3;
            for (int i = startingRow; i < startingRow + 3; i++) {
                for (int j = startingColumn; j < startingColumn + 3; j++) {
                    if (board[i][j] != '.') {
                        presentDigits[board[i][j] - '1'] = true;
                    }
                }
            }
            Set<Integer> missingDigits = new HashSet<>();
            for (int k = 0; k < presentDigits.length; k++) {
                if (!presentDigits[k]) {
                    missingDigits.add(k + 1);
                }
            }
            squares.put(squareNumber, missingDigits);
            squareNumber++;
        }
    }

    private void putMissingNumberIntoRows(Map<Integer, Set<Integer>> rows, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] presentDigits = new boolean[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    presentDigits[board[i][j] - '1'] = true;
                }
            }
            Set<Integer> missingDigits = new HashSet<>();
            for (int k = 0; k < presentDigits.length; k++) {
                if (!presentDigits[k]) {
                    missingDigits.add(k + 1);
                }
            }
            rows.put(i, missingDigits);
        }
    }

    private void putMissingNumbersIntoColumns(Map<Integer, Set<Integer>> columns, char[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            boolean[] presentDigits = new boolean[9];
            for (char[] chars : board) {
                if (chars[j] != '.') {
                    presentDigits[chars[j] - '1'] = true;
                }
            }
            Set<Integer> missingDigits = new HashSet<>();
            for (int i = 0; i < presentDigits.length; i++) {
                if (!presentDigits[i]) {
                    missingDigits.add(i + 1);
                }
            }
            columns.put(j, missingDigits);
        }
    }

    public String toString(char[][] board) {
        StringBuilder stb = new StringBuilder();
        for (char[] chars : board) {
            for (char aChar : chars) {
                stb.append(aChar);
                stb.append(',');
            }
            stb.append("\n");
        }
        return stb.toString();
    }

    private void solveBoard(char[][] board, Map<Integer, Set<Integer>> squares,
                            Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> columns) {
        boolean stillHasChanges = true;
        while (stillHasChanges) {
            stillHasChanges = false;
            for (Map.Entry<Integer, Set<Integer>> square : squares.entrySet()) {
                if (!square.getValue().isEmpty()) {
                    if (cellWasFilled(square, board, rows, columns)) {
                        checkRows(rows, columns, board, squares);
                        checkColumns(columns, rows, board, squares);
                        stillHasChanges = true;
                    }
                }
            }
        }
        // check if everything is filled; if not, we start doing backtrack
        boolean backTracking = false;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '.') {
                    backTracking = true;
                    break;
                }
            }
        }
        if (backTracking) {
            doBackTracking(board, squares, rows, columns);
        }
    }

    private boolean cellWasFilled(Map.Entry<Integer, Set<Integer>> square, char[][] board,
                                  Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> columns) {
        boolean wasFilled = false;
        int startingRow = square.getKey() - square.getKey() % 3;
        int startingColumn = (square.getKey() % 3) * 3;
        if (!square.getValue().isEmpty()) {
            Iterator<Integer> iterator = square.getValue().iterator();
            while(iterator.hasNext()) {
                int missingNumber = iterator.next();
                int missingTimes = 0, missingI = 0, missingJ = 0;
                for (int i = startingRow; i < startingRow + 3; i++) {
                    for (int j = startingColumn; j < startingColumn + 3; j++) {
                        if (board[i][j] == '.') {
                            if (rows.get(i) != null && rows.get(i).contains(missingNumber)
                                && columns.get(j) != null && columns.get(j).contains(missingNumber)) {
                                missingTimes++;
                                missingI = i;
                                missingJ = j;
                            }
                        }
                    }
                }
                // if one cell is fit for completion, complete it!
                if (missingTimes == 1) {
                    // remove from board
                    board[missingI][missingJ] = (char) (missingNumber + '0');
                    // remove from rows
                    rows.get(missingI).remove(missingNumber);
                    // remove from columns
                    columns.get(missingJ).remove(missingNumber);
                    // remove from cell
                    iterator.remove();
                    wasFilled = true;
                }
            }
        }
        return wasFilled;
    }

    private void checkRows(Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> columns, char[][] board,
                           Map<Integer, Set<Integer>> squares) {
        for (Map.Entry<Integer, Set<Integer>> row : rows.entrySet()) {
            if (row.getValue().size() == 1) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[row.getKey()][j] == '.') {
                        // mark it on the board
                        int digitToMark = row.getValue().stream().findFirst().get();
                        board[row.getKey()][j] =  (char)('0' + digitToMark);
                        // remove from columns
                        columns.get(j).remove(digitToMark);
                        // remove from square
                        squares.get(getSquareNumber(row.getKey(), j)).remove(digitToMark);
                        // remove from row
                        row.getValue().clear();
                        break;
                    }
                }
            }
        }
    }

    private void checkColumns(Map<Integer, Set<Integer>> columns, Map<Integer, Set<Integer>> rows,
                              char[][] board, Map<Integer, Set<Integer>> squares) {
        for (Map.Entry<Integer, Set<Integer>> column : columns.entrySet()) {
            if (column.getValue().size() == 1) {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][column.getKey()] == '.') {
                        // mark it on the board
                        int digitToMark = column.getValue().stream().findFirst().get();
                        board[i][column.getKey()] =  (char)('0' + digitToMark);
                        // remove from row
                        rows.get(i).remove(digitToMark);
                        // remove from columns
                        column.getValue().clear();
                        // remove from square
                        squares.get(getSquareNumber(i, column.getKey())).remove(digitToMark);
                        break;
                    }
                }
            }
        }
    }

    private int getSquareNumber(int i, int j) {
        if (i < 3) return j / 3;
        if (i < 6) return 3 + j / 3;
        else return 6 + j / 3;
    }

    private void doBackTracking(char[][] board, Map<Integer, Set<Integer>> squares,
                                Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> columns) {
        char[][] boardSnapshot = copy(board);
        Map<Integer, Set<Integer>> squaresSnapshot = copy(squares);
        Map<Integer, Set<Integer>> rowsSnapshot = copy(squares);
        Map<Integer, Set<Integer>> columnsSnapshot = copy(squares);

    }

    private char[][] copy(char[][] board) {
        char[][] clone =  new char[board.length][board[0].length];
        for(int i = 0; i < clone.length; i++) {
            System.arraycopy(board[i], 0, clone[i], 0, clone[i].length);
        }
        return clone;
    }

    private Map<Integer, Set<Integer>> copy(Map<Integer, Set<Integer>> toCopy) {
        Map<Integer, Set<Integer>> clone = new HashMap<>();
        toCopy.forEach((k, v) -> clone.put(k, new HashSet<>(v)));
        return clone;
    }
}