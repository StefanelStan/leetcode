package com.ss.leetcode.april;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class QueensThatCanAttackTheKing {
    // https://leetcode.com/problems/queens-that-can-attack-the-king/
    private static final int BOARD_SIZE = 8;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final List<List<Integer>> attackingQueens = new LinkedList<>();
        boolean[][] queenBoard = getQueenBoard(queens);
        addHorizontallyAttackingQueens(queenBoard, king, attackingQueens);
        addVerticallyAttackingQueens(queenBoard, king, attackingQueens);
        addDiagonallyAttackingQueens(queenBoard, king, attackingQueens);
        return attackingQueens;
    }

    private boolean[][] getQueenBoard(int[][] queens) {
        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }
        return board;
    }

    private void addHorizontallyAttackingQueens(boolean[][] board, int[] king, List<List<Integer>> attackingQueens) {
        for (int j = king[1] -1; j >= 0; j--) {
            if (board[king[0]][j]) {
                attackingQueens.add(List.of(king[0], j));
                break;
            }
        }
        for (int j = king[1] + 1; j < board.length; j++) {
            if (board[king[0]][j]) {
                attackingQueens.add(List.of(king[0], j));
                break;
            }
        }
    }

    private void addVerticallyAttackingQueens(boolean[][] board, int[] king, List<List<Integer>> attackingQueens) {
        for (int i = king[0] - 1; i >= 0; i--) {
            if (board[i][king[1]]) {
                attackingQueens.add(List.of(i, king[1]));
                break;
            }
        }
        for (int i = king[0] + 1; i < board.length; i++) {
            if (board[i][king[1]]) {
                attackingQueens.add(List.of(i, king[1]));
                break;
            }
        }
    }

    private void addDiagonallyAttackingQueens(boolean[][] board, int[] king, List<List<Integer>> attackingQueens) {
        // diagonal 1 up and down
        for (int i = king[0] -1, j = king[1] -1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }

        for (int i = king[0] + 1, j = king[1] + 1; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++) {
            if (board[i][j]) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }

        //diagonal 2 up and down
        for (int i = king[0] -1, j = king[1] + 1; i >= 0 && j < BOARD_SIZE; i--, j++) {
            if (board[i][j]) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }

        for (int i = king[0] + 1, j = king[1] - 1; i < BOARD_SIZE && j >= 0; i++, j--) {
            if (board[i][j]) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }
    }



    /**
     * Solution is good only for very large sets due to keeping only sets/maps in memory.
     * In small version like this, it's faster to preallocate a boolean matrix and loop over it.
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final List<List<Integer>> attackingQueens = new LinkedList<>();
        Map<Integer, SortedSet<Integer>> sortedByRowQueens = sortQueensByRow(queens);
        addHorizontallyAttackingQueens(sortedByRowQueens, king, attackingQueens);
        addVerticallyAttackingQueens(sortedByRowQueens, king, attackingQueens);
        addDiagonallyAttackingQueens(sortedByRowQueens, king, attackingQueens);
        return attackingQueens;
    }

    private Map<Integer, SortedSet<Integer>> sortQueensByRow(int[][] queens) {
        Map<Integer, SortedSet<Integer>> queensMap = new HashMap<>();
        for (int[] queen : queens) {
            SortedSet<Integer> set = queensMap.get(queen[0]);
            if (set == null) {
                set = new TreeSet<>();
                set.add(queen[1]);
                queensMap.put(queen[0], set);
            } else {
                set.add(queen[1]);
            }
        }
        return queensMap;
    }

    private void addHorizontallyAttackingQueens(Map<Integer, SortedSet<Integer>> queens, int[] king, List<List<Integer>> attackingQueens) {
        SortedSet<Integer> columnsQueens = queens.get(king[0]);
        if (columnsQueens != null && !columnsQueens.isEmpty()) {
            SortedSet<Integer> headSet = columnsQueens.headSet(king[1]);
            if (!headSet.isEmpty()) {
                attackingQueens.add(List.of(king[0], headSet.last()));
            }
        }

        if (columnsQueens != null && !columnsQueens.isEmpty()) {
            SortedSet<Integer> tailSet = columnsQueens.tailSet(king[1] + 1);
            if (!tailSet.isEmpty()) {
                attackingQueens.add(List.of(king[0], tailSet.first()));
            }
        }
    }

    private void addVerticallyAttackingQueens(Map<Integer, SortedSet<Integer>> queens, int[] king, List<List<Integer>> attackingQueens) {
        for (int i = king[0] - 1; i >= 0; i--) {
            SortedSet<Integer> colQueens = queens.get(i);
            if (colQueens != null && colQueens.contains(king[1])) {
                attackingQueens.add(List.of(i, king[1]));
                break;
            }
        }

        for (int i = king[0] + 1; i < BOARD_SIZE; i++) {
            SortedSet<Integer> colQueens = queens.get(i);
            if (colQueens!= null && colQueens.contains(king[1])) {
                attackingQueens.add(List.of(i, king[1]));
                break;
            }
        }
    }

    private void addDiagonallyAttackingQueens(Map<Integer, SortedSet<Integer>> queens, int[] king, List<List<Integer>> attackingQueens) {
        // diagonal 1 up and down
        for (int i = king[0] -1, j = king[1] -1; i >= 0 && j >= 0; i--, j--) {
            SortedSet<Integer> colQueens = queens.get(i);
            if (colQueens!= null && colQueens.contains(j)) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }

        for (int i = king[0] + 1, j = king[1] + 1; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++) {
            SortedSet<Integer> colQueens = queens.get(i);
            if (colQueens!= null && colQueens.contains(j)) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }

        //diagonal 2 up and down
        for (int i = king[0] -1, j = king[1] + 1; i >= 0 && j < BOARD_SIZE; i--, j++) {
            SortedSet<Integer> colQueens = queens.get(i);
            if (colQueens!= null && colQueens.contains(j)) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }

        for (int i = king[0] + 1, j = king[1] - 1; i < BOARD_SIZE && j >= 0; i++, j--) {
            SortedSet<Integer> colQueens = queens.get(i);
            if (colQueens!= null && colQueens.contains(j)) {
                attackingQueens.add(List.of(i, j));
                break;
            }
        }
    }
    */
}
