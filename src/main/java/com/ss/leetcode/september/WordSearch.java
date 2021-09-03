package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    // https://leetcode.com/problems/word-search/
    private final int CONTINUE = 0, FOUND = 1, STOP = 2;
    public boolean exist(char[][] board, String word) {

        int[] status = {CONTINUE};
        List<int[]>[] allCharsPos = getPositions(board);
        searchWord(board, word, 0, allCharsPos, status);
        return status[0] == FOUND;
    }

    private List<int[]>[] getPositions(char[][] board) {
        List<int[]>[] positions = new ArrayList['z' - 'A' + 1];
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                List<int[]> position = positions[board[i][j] - 'A'];
                if (position == null) {
                    position = new ArrayList<>();
                    positions[board[i][j] - 'A'] = position;
                }
                position.add(new int[]{i,j});
            }
        }
        return positions;
    }

    private void searchWord(char[][] board, String word, int index, List<int[]>[] allCharPos, int[] status) {
        List<int[]> foundPositions = allCharPos[word.charAt(index) - 'A'];
        if(foundPositions != null) {
            if(word.length() == 1) {
                status[0] = FOUND;
                return;
            }
            for (int[] charPosition : foundPositions) {
                if (status[0] == CONTINUE) {
                    Set<int[]> usedPos = new HashSet<>();
                    usedPos.add(charPosition);
                    findNextPosition(board, word, index + 1, charPosition, usedPos, allCharPos, status);
                }
            }
        }
    }

    private void findNextPosition(char[][] board, String word, int index, int[] prevPos,
                                  Set<int[]> usedPositions, List<int[]>[] allCharPos, int[] status) {
        if (index < word.length() || status[0] == CONTINUE) {
            List<int[]> nextPositions = allCharPos[word.charAt(index) - 'A'];
            if (nextPositions == null) {
                status[0] = STOP;
                return;
            }
            for (int[] nextPos : nextPositions) {
                if (isNearbyPosition(prevPos, nextPos) && !usedPositions.contains(nextPos) && status[0] == CONTINUE) {
                    if (index == word.length() -1) {
                        status[0] = FOUND;
                        return;
                    }
                    Set<int[]> trail = new HashSet<>(usedPositions);
                    trail.add(nextPos);
                    findNextPosition(board, word, index + 1, nextPos, trail, allCharPos, status);
                }
            }
        }
    }

    private boolean isNearbyPosition(int[] cell1, int[] cell2) {
        if (cell1[0] == cell2[0]) {
            return Math.abs(cell1[1] - cell2[1]) == 1;
        }
        if (cell1[1] == cell2[1]) {
            return Math.abs(cell1[0] - cell2[0]) == 1;
        }
        return false;
    }
}
