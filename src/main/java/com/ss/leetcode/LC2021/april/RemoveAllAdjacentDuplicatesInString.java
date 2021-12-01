package com.ss.leetcode.LC2021.april;

public class RemoveAllAdjacentDuplicatesInString {
    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
    public String removeDuplicates(String str) {
        boolean[] removedPositions = new boolean[str.length()];
        boolean hasDuplicates = true;
        while (hasDuplicates) {
            hasDuplicates = false;
            int nextValidPosition = getNextPosition(-1, removedPositions);
            if (nextValidPosition >= str.length()) {
                break;
            }
            for (int i = nextValidPosition + 1; i < str.length() && nextValidPosition < str.length();) {
                if (!removedPositions[i]) {
                    if (str.charAt(nextValidPosition) == str.charAt(i)) {
                        removedPositions[nextValidPosition] = true;
                        removedPositions[i] = true;
                        hasDuplicates =  true;
                        nextValidPosition = getNextPosition(i, removedPositions);
                        i = nextValidPosition++;
                    } else {
                        nextValidPosition = i;
                        i = getNextPosition(nextValidPosition, removedPositions);
                    }
                } else {
                    i++;
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < removedPositions.length; i++) {
            if (!removedPositions[i]) {
                stb.append(str.charAt(i));
            }
        }
        return stb.toString();
    }

    private int getNextPosition(int start, boolean[] removedPositions) {
        for (int i = start + 1; i < removedPositions.length; i++) {
            if (!removedPositions[i]) {
                return i;
            }
        }
        return removedPositions.length;
    }
}
