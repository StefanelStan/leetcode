package com.ss.leetcode.LC2022.september;

public class NumberOfGoodWaysToSplitAString {
    /** Algorithm
         1. Apply two sliding windows: left and right. Initially they have the length 1 (n-1)
         and gradually expand/shrink (2 & n-2, 3 & n-3).
         2. SlidingWindow object: keep track of the present chars in an int[26] AND unique/distinct characters
         3. Adding one char to window: if the current count of that char is 0, then you will have one extra distinct character.
            If that char exists already, don't you must not increase the count of distinct characters
         4. Removing one char: if count becomes 0, then you will have one less distinct char.
         5. For each index 1..n-1, add one char on left window and remove one char from right.
         If their distinct nr is equal, then it's a good split.
         6. Return the nr of good splits.
     */
    public int numSplits(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] chrs = s.toCharArray();
        StringWindow left = new StringWindow();
        StringWindow right = getStringWindow(chrs, 0, chrs.length -1);
        int numSplits = 0;
        for (int i = 0; i < chrs.length -1; i++) {
            left.addChar(chrs[i] - 'a');
            right.removeChar(chrs[i] - 'a');
            if (left.uniqueLetters == right.uniqueLetters) {
                numSplits++;
            }
        }
        return numSplits;
    }

    private StringWindow getStringWindow(char[] chrs, int start, int end) {
        StringWindow sw = new StringWindow();
        while(start <= end) {
            sw.addChar(chrs[start] - 'a');
            start++;
        }
        return sw;
    }

    private static final class StringWindow {
        private int[] letters;
        private int uniqueLetters;

        public StringWindow() {
            letters = new int[26];
        }

        public void addChar(int codePoint) {
            // if this is a new char/if the new count is 1, then increment the unique Letters count
            if (++letters[codePoint] == 1) {
                uniqueLetters++;
            }
        }

        public void removeChar(int codePoint) {
            // // if the new count is 1, then we lost one distinct/unique character.
            if (--letters[codePoint] == 0) {
                uniqueLetters--;
            }
        }
    }
}
