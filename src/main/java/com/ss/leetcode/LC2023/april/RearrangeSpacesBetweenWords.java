package com.ss.leetcode.LC2023.april;

public class RearrangeSpacesBetweenWords {
    // https://leetcode.com/problems/rearrange-spaces-between-words
    /** Algorithm
        1. Convert text to char[] as you will parse it twice.
        2. Traverse char[] and count the spaces and number of words
        3. Determine the distance between words: spaces - (max (1, words - 1)).
        4. Traverse char[]
            - if you are on a letter, add it. (and set a flag to true)
            - if you are on a space and the flag is true, it means you have just added a word. Add the spaces.
            - deduct the number of added spaces from the total number of available spaces
        5. At the end, if you still have spaces (text might end with a char but have extra spaces in front)
     */
    public String reorderSpaces(String text) {
        char[] chrs = text.toCharArray();
        int[] spacesAndWords = countSpacesAndWords(chrs);
        if (spacesAndWords[0] == 0) {
            return text;
        }
        return reorderSpaces(chrs, spacesAndWords[0], spacesAndWords[1]);
    }

    private String reorderSpaces(char[] chrs, int spaces, int words) {
        int distance = spaces / (Math.max(1, words - 1));
        boolean insertingWord = false;
        StringBuilder stb = new StringBuilder(chrs.length);
        for (char c : chrs) {
            if (c == ' ') {
                if (insertingWord) { // if you have just finished adding a word, add the number of spaces
                    insertingWord = false;
                    addSpaces(stb, Math.min(distance, spaces));
                    spaces -= Math.min(distance, spaces);
                }
            } else { // insert each letter
                insertingWord = true;
                stb.append(c);
            }
        }
        addSpaces(stb, spaces);
        return stb.toString();
    }

    private void addSpaces(StringBuilder stb, int spaces) {
        while (spaces > 0) {
            stb.append(' ');
            spaces--;
        }
    }

    private int[] countSpacesAndWords(char[] chrs) {
        int[] spacesAndWords = new int[2];
        boolean insideWord = false;
        for (char c : chrs) {
            if (c == ' ') {
                spacesAndWords[0]++;
                insideWord = false;
            } else if (!insideWord) {
                insideWord = true;
                spacesAndWords[1]++;
            }
        }
        return spacesAndWords;
    }
}
