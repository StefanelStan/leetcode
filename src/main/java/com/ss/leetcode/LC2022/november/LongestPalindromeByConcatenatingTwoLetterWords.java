package com.ss.leetcode.LC2022.november;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    // https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
    /** Algorithm
         1. In order to build a palindrime, you need to pair words and their reflections EG: "ab" & "ba".
         2. Thus, count how many words you have of each type. If you have 3 ab and 2 ba, it
            means you can only select min(3,2) groups that can be stored like ababbaba
            Thus, the length is increased by 2 * 4 (each group abba has a length of 4)
         3. Pay attention to the edge cases: "aa", "aa", "aa".
            In this case the word itself is a palindrome, so you can add it only half of times.
            (3/2) -> 1 group "aaaa".
            In this case, we are left with 2 "aa" that can be used inside a palindrome,
            but just one single time for ALL exiting words.
            EG: "aa","aa","bb" -> aabbaa. The single palindrome word "bb" is put in the middle,
            but this can be done just one time for all the existing words.
         4. For faster access and better memory, DO NOT USE A MAP, but an int[26][26].
            "ab" will be accessed via [0][1]
     */
    public int longestPalindrome(String[] words) {
        int[][] letterWords = new int[26][26];
        // count each words and store them in the matrix "cd" will be at [2][3] [c-'a'][d-'a']
        for (String word : words) {
            letterWords[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        int longest = 0, minOp;
        boolean singlePairUsed = false;
        // due to even length palindrome, we can have a palindrome word (eg: "aa" or bb) right in the middle.
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j <= i; j++) {
                // if both the word and its reflection are > 0
                if (letterWords[i][j] > 0 && letterWords[j][i] > 0) {
                    // treat the edge cases "aaaa".
                    if (i == j) {
                        minOp = letterWords[i][j] / 2;
                        letterWords[i][j] -= minOp * 2;
                        longest += minOp * 4;
                        // try to see if you can one single palindromatic word and you didn't use it yet
                        if (letterWords[i][j] == 1 && !singlePairUsed) {
                            letterWords[i][j] = 0;
                            singlePairUsed = true;
                            longest += 2;
                        }
                    } else { // else generic case ab ba
                        minOp = Math.min(letterWords[i][j], letterWords[j][i]);
                        letterWords[i][j] = minOp;
                        letterWords[j][i] = 0;
                        longest += minOp * 4;
                    }
                }
            }
        }
        return longest;
    }
}
