package com.ss.leetcode.LC2021.may;

public class CheckIfTwoStringsAreEquivalent {
    // https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        boolean areEqual = true;
        StringPointer pointerOne = new StringPointer();
        StringPointer pointerTwo = new StringPointer();
        while(areEqual && pointerOne.arrayIndex != word1.length && pointerTwo.arrayIndex != word2.length) {
            areEqual = advancePointer(word1, pointerOne) == advancePointer(word2, pointerTwo);
        }
        return areEqual && pointerOne.arrayIndex == word1.length && pointerTwo.arrayIndex == word2.length;
    }

    private char advancePointer(String[] word, StringPointer pointer) {
        char ch = word[pointer.arrayIndex].charAt(pointer.stringIndex);
        if (++pointer.stringIndex == word[pointer.arrayIndex].length()) {
            pointer.stringIndex = 0;
            pointer.arrayIndex++;
        }
        return ch;
    }

    private static class StringPointer {
        int arrayIndex;
        int stringIndex;
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int word1i = 0, word1j = 0, word2i = 0, word2j = 0;
        while (true) {
            if (word1[word1i].charAt(word1j) != word2[word2i].charAt(word2j)) {
                return false;
            }
            if ((word1i == word1.length -1 && word1j == word1[word1i].length() -1)
                || (word2i == word2.length - 1 && word2j == word2[word2i].length() - 1)) {
                break;
            } else {
                if (word1j == word1[word1i].length() - 1) {
                    word1i++;
                    word1j = 0;
                } else {
                    word1j++;
                }
                if (word2j == word2[word2i].length() - 1) {
                    word2i++;
                    word2j = 0;
                } else {
                    word2j++;
                }
            }
        }
        return word1i == word1.length - 1 && word1j == word1[word1i].length() - 1 &&
            word2i == word2.length - 1 && word2j == word2[word2i].length() - 1;
    }

    public boolean arrayStringsAreEqual3(String[] word1, String[] word2) {
        StringBuilder stb1 = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();

        for (String section : word1) {
            stb1.append(section);
        }
        for (String section : word2) {
            stb2.append(section);
        }
        return stb1.toString().contentEquals(stb2);
    }
}
