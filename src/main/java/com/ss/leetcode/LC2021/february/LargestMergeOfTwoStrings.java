package com.ss.leetcode.LC2021.february;

public class LargestMergeOfTwoStrings {
    // https://leetcode.com/problems/largest-merge-of-two-strings/
    public String largestMerge(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2;
        }
        if (word2.isEmpty()) {
            return word1;
        }


        final int totalLength = word1.length() + word2.length();
        StringBuilder stb = new StringBuilder(totalLength);
        boolean word1Finished = false;
        boolean word2Finished = false;
        for (int i = 0, j = 0; stb.length() < totalLength; ) {
            if (word1Finished) {
                stb.append(word2, j, word2.length());
                break;
            } else if (word2Finished) {
                stb.append(word1, i, word1.length());
                break;
            }
            if (word1.charAt(i) > word2.charAt(j)) {
                stb.append(word1.charAt(i));
                i++;
                if (i >= word1.length()) {
                    word1Finished = true;
                }
            } else if (word2.charAt(j) > word1.charAt(i)) {
                stb.append(word2.charAt(j));
                j++;
                if (j >= word2.length()) {
                    word2Finished = true;
                }
            } else {
                // two letters are same; append the first one index
                boolean isWord1Largest = getLargestNextSequence(word1, word2, i, j);
                if (isWord1Largest) {
                    stb.append(word1, i, ++i);
                    if (i >= word1.length()) {
                        word1Finished = true;
                    }
                } else {
                    stb.append(word2, j, ++j);
                    if (j >= word2.length()) {
                        word2Finished = true;
                    }
                }
            }
        }
        return stb.toString();
    }

    private boolean getLargestNextSequence(String word1, String word2, int w1Index, int w2Index) {
        for (int i = w1Index, j = w2Index; i < word1.length() && j < word2.length(); ) {
            if (word1.charAt(i) > word2.charAt(j)) {
                return true;
            } else if (word2.charAt(j) > word1.charAt(i)) {
                return false;
            }
            if (i == word1.length() - 1 && j == word2.length() - 1) {
                return true;
            } else {
                if (i < word1.length() - 1) i++;
                if (j < word2.length() - 1) j++;
            }
        }
        return false;
    }
}
