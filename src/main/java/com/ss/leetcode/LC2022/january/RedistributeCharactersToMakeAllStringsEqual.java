package com.ss.leetcode.LC2022.january;

public class RedistributeCharactersToMakeAllStringsEqual {
    // https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
    /** Algorithm
     1. In order for n string to be equal, they need to have (at least) the same amount of each individual characters. (hence we can move any chanater to any place, we treat them anagrams )
     2. Thus, for each word, count and add the characters and add them to a gloval variable
     3. For each char, the number of chars needs to be divisible by number of proposed words.
     EG1: "abca", "abca" (4a,2b, 2c -> each nr of chars needs to % nr of words)
     EG2: "abcd", "abca" (3a, 2b, 1c, 1d) (3,1,1 are not divisible by nr of words)
     */
    public boolean makeEqual(String[] words) {
        int[] count = countWords(words);
        for(int c : count) {
            if (c % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] countWords(String[] words) {
        int[] count = new int[26];
        for(String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
        }
        return count;
    }
}
