package com.ss.leetcode.LC2021.september;

public class CheckIfAWordPrefixInASentence {
    // https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
    /** Algorithm
        1. Traverse sentence using a flag startingWord that gets resetted after each blank (space)
        2. If current char is a letter and your flag is true, set flag to false and check if string contains searchWord from that index.
            - If yes, return word count, else just increment word count.
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        boolean startingWord = true;
        char ch;
        int wordIndex = 1;
        for (int i = 0; i <= sentence.length() - searchWord.length(); i++) {
            ch = sentence.charAt(i);
            if (ch == ' ') {
                startingWord = true;
            } else if (startingWord) {
                startingWord = false;
                if (sentence.startsWith(searchWord, i)) {
                    return wordIndex;
                }
                wordIndex++;
            }
        }
        return -1;
    }


    public int isPrefixOfWord2(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for(int i = 0;  i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i +1;
            }
        }
        return -1;
    }
}
