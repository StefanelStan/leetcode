package com.ss.leetcode.may;

public class CheckIfTwoStringsAreEquivalent {
    // https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stb1 = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();

        for (String section : word1) {
            stb1.append(section);
        }
        for (String section : word2) {
            stb2.append(section);
        }
        return stb1.toString().equals(stb2.toString());
    }
}
