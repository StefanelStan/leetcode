package com.ss.leetcode.LC2025.january;

import java.util.Arrays;

public class CountTheNumberOfSpecialCharactersII {
    // https://leetcode.com/problems/count-the-number-of-special-characters-ii
    /** Algorithm
        1. Use an int[z + 1] indices to traverse  and store the 1st pos of UpperCase letters and last position of lowercase letters.
        2. Traverse indices from a to z(97 - 122)
            - if indices[i] != -1 && indices[i] < indices[i -32] (last lowercase lesser than first uppercase) index, increment count
     */
    public int numberOfSpecialChars(String word) {
        int[] indices = getIndices(word);
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (indices[i] != -1 && indices[i] < indices[i - 32]) {
                count++;
            }
        }
        return count;
    }

    private int[] getIndices(String word) {
        int[] indices = new int['z' + 1];
        Arrays.fill(indices, -1);
        char currentChar;
        for (int i = 0; i < word.length(); i++) {
            currentChar = word.charAt(i);
            if (currentChar >= 'a') {
                indices[currentChar] = i;
            } else if (indices[currentChar] == -1) {
                indices[currentChar] = i;
            }
        }
        return indices;
    }
}
