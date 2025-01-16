package com.ss.leetcode.LC2025.january;

public class CountSubstringsThatCanBeRearrangedToContainAStringII {
    // https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii
    /** Algorithm
        1. Use Sliding Window technique : count the chars from word2 in int[] count
        2. For a substring to be valid, it needs to have at least all the chars (and cardinal) inside count[]
        3. Expand right pointer until window becomes valid. From that point, you have n - right substrings
        4. Remove the char the left pointer.
     */
    public long validSubstringCount(String word1, String word2) {
        long count = 0;
        SubstringWindow window = new SubstringWindow(word2);
        int left = 0, right = 0;
        while (left < word1.length() && !(right == word1.length() && !window.isValid())) {
            while(right < word1.length() && !window.isValid()) {
                window.addChar(word1.charAt(right++) - 'a');
            }
            count += window.isValid() ? 1 + word1.length() - right : 0;
            window.removeChar(word1.charAt(left++) - 'a');
        }
        return count;
    }

    private static class SubstringWindow {
        int[] requiredChars;
        int[] currentChars;
        int totalRequired;
        int currentPresent;
        public SubstringWindow(String word) {
            this.requiredChars = getRequired(word);
            currentChars = new int[26];
        }

        private int[] getRequired(String word) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
            for (int c : count) {
                if (c > 0) {
                    totalRequired++;
                }
            }
            return count;
        }

        private void addChar(int codePoint) {
            if (requiredChars[codePoint] != 0 && ++currentChars[codePoint] == requiredChars[codePoint]) {
                currentPresent++;
            }
        }

        private void removeChar(int codePoint) {
            if (requiredChars[codePoint] != 0 && currentChars[codePoint] == requiredChars[codePoint]) {
                currentPresent--;
            }
            currentChars[codePoint]--;
        }

        private boolean isValid() {
            return currentPresent == totalRequired;
        }
    }
}
