package com.ss.leetcode.LC2021.december;

import java.util.Arrays;

public class ExecutionOfAllSuffixInstructionsGrid {
    // https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] instructions = new int[s.length()];
        int currRow, currCol;
        boolean shouldContinue = true;
        for (int i = 0; i < s.length(); i++) {
            currRow = startPos[0];
            currCol = startPos[1];
            shouldContinue = true;
            for (int index = i; index < s.length() && shouldContinue; index++) {
                switch (s.charAt(index)) {
                    case 'L' -> {
                        currCol--;
                        if (currCol < 0) {
                            shouldContinue = false;
                        }
                    }
                    case 'R' -> {
                        currCol++;
                        if (currCol == n) {
                            shouldContinue = false;
                        }
                    }
                    case 'U' -> {
                        currRow--;
                        if(currRow < 0) {
                            shouldContinue = false;
                        }
                    }
                    // D
                    default -> {
                        currRow++;
                        if(currRow == n) {
                            shouldContinue = false;
                        }
                    }
                }
                if (shouldContinue) {
                    instructions[i]++;
                }
            }
        }
        return instructions;
    }

    public int[] executeInstructions2(int n, int[] startPos, String s) {
        int[] instructions = new int[s.length()];
        int[] currentPos;
        for (int i = 0; i < s.length(); i++) {
            currentPos = new int[]{startPos[0], startPos[1]};
            for (int index = i; index < s.length(); index++) {
                executeInstruction(currentPos, s.charAt(index));
                if (currentPos[0] >= 0 && currentPos[0] < n && currentPos[1] >= 0 && currentPos[1] < n) {
                    instructions[i]++;
                } else {
                    break;
                }
            }
        }
        return instructions;
    }

    private void executeInstruction(int[] position, char direction) {
        switch (direction) {
            case 'L' -> position[1]--;
            case 'R' -> position[1]++;
            case 'U' -> position[0]--;
            // D
            default -> position[0]++;
        }
    }
}
