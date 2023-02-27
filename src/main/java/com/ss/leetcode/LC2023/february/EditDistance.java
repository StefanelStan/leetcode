package com.ss.leetcode.LC2023.february;

public class EditDistance {
    // https://leetcode.com/problems/edit-distance
    /** As per notes:
     * 1. Start from i = word1.length, j - word2.length
     * 2. If i or j == 0, return the other index, signalling that the remaining chars can be deleted
     * 3. If bestCost[i][j] has been calculated, return it
     * 4. If the two chars match, move both indices left and continue. The result of this will be cached to bestCost[i][j]
     * 5. Else, determine the cost of deletion replace (i-1, j-1), deleting(i-1, j), insert(i, j-1).
     *    The min of these 3 + 1 will be set to bestCost[i][j] and returned.
     */
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length(), word2.length());
    }

    private int minDistance(String word1, String word2, int word1Index, int word2Index) {
        // if word1 is empty, then word2 might have some letters that can be deleted, so distance is word2Index
        if (word1Index == 0) {
            return word2Index;
        } else if (word2Index == 0) {
            return word1Index;
        }
        // if two letters match, move to next letter in both words
        if (word1.charAt(word1Index -1) == word2.charAt(word2Index -1)) {
            return minDistance(word1, word2, word1Index-1, word2Index -1);
        } else {
            // calculate the min of 3 operations: deletion, insert, replace
            int replaceCost = minDistance(word1, word2, word1Index -1, word2Index-1); // both indices move left by 1 pos
            int deletionCost = minDistance(word1, word2, word1Index-1, word2Index); // word1Index moves 1 position to left
            int insertionCost = minDistance(word1, word2, word1Index, word2Index -1); // wordIndex1 stays put while word2Index moved left
            return Math.min(deletionCost, Math.min(insertionCost, replaceCost)) + 1;
        }
    }

    public int minDistanceTopDown(String word1, String word2) {
        Integer[][] bestCost = new Integer[word1.length()+1][word2.length()+1];
        return minDistanceTopDown(word1, word2, word1.length(), word2.length(), bestCost);
    }

    private int minDistanceTopDown(String word1, String word2, int word1Index, int word2Index, Integer[][] bestCost) {
        if(word1Index == 0) {
            return word2Index;
        }
        if (word2Index == 0) {
            return word1Index;
        }
        if (bestCost[word1Index][word2Index] != null) {
            return bestCost[word1Index][word2Index];
        }
        int minEditDistance = 0;
        if (word1.charAt(word1Index-1) == word2.charAt(word2Index -1)) {
            minEditDistance = minDistanceTopDown(word1, word2, word1Index-1, word2Index -1, bestCost);
        } else {
            int minReplaceCost = minDistanceTopDown(word1, word2, word1Index-1, word2Index-1, bestCost);
            int minInsertCost = minDistanceTopDown(word1, word2, word1Index, word2Index -1, bestCost);
            int minDeleteCost = minDistanceTopDown(word1, word2, word1Index -1, word2Index, bestCost);
            minEditDistance = Math.min(minReplaceCost, Math.min(minInsertCost, minDeleteCost)) + 1;
        }
        bestCost[word1Index][word2Index] = minEditDistance;
        return minEditDistance;
    }
}
