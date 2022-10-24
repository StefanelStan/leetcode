package com.ss.leetcode.LC2022.october;

import java.util.LinkedList;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {
    /** Algorithm
         1. Quick fail fast: if words has length of 1, return false immeditely
         2. Use a linkedList to store the "survivor" words: words that are the i-1 index.
         3. Add the first word in this list
         4. Starting from i =1, check if words[i] and linkedList.peekLast() are anagrams.
             If they are NOT, then add words[i] to this list.
             If they ARE, then move i to next index and ignore this word[i], as it will not be part of the answer.
         5. Return the list.
     */
    public List<String> removeAnagrams(String[] words) {
        if (words.length == 1) {
            return List.of(words[0]);
        }
        LinkedList<String> checkedWords = new LinkedList<>();
        checkedWords.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!areAnagrams(words[i], checkedWords.peekLast())) {
                checkedWords.add(words[i]);
            }
        }
        return checkedWords;
    }

    // Count the letters of first words
    // Start deducting the letters of 2nd word one by one. If -1 is ever reached, return false immediately
    private boolean areAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            if(--count[word2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
