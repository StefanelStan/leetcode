package com.ss.leetcode.LC2022.july;

import java.util.LinkedList;
import java.util.List;

public class WordSubsets {
    // https://leetcode.com/problems/word-subsets/
    /** Algorithm
         - EG: words1 = [abc, def], words2 = [ab, ac]
         1. Looking at the task, normally you would want to check abc against every word of words2.
            However, this is not efficient, because you would have to iterate over all words of words2
         2. If abc was to match ab and ac, then maybe we can make a "superword" from ALL words of words2.
             If abc is to match this superword, then it will match ALL the words from words2
         3. [ab, ac] . We have [1a, 1b] and [1a, 1c]. Looking at this, we can see that the superword
             needs to have 1a, 1b and 1c.
            eg2 : [a, aa, aaa] -> our superword needs to have 3a. Always the maximum occurance
         4. Putting these together
            - Get the superword from words2 and count its letters in an int[26].
            - Match every word of word1 against this superword.
            If the superword has more letters of type X (more c) than the given word, then that word is not universal
         5. Return the list of universal words
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> subsets = new LinkedList<>();
        int[] joinedWords = joinAndCountWords(words2);
        for (String word : words1) {
            if (isUniversalSubset(countWordLetters(word.toCharArray()), joinedWords)) {
                subsets.add(word);
            }
        }
        return subsets;
    }

    // create the superWord of words2.
    private int[] joinAndCountWords(String[] words) {
        int[] totalCount = new int[26];
        for (String word : words) {
            int[] letterCount = countWordLetters(word.toCharArray());
            for (int i = 0; i < totalCount.length; i++) {
                totalCount[i] = Math.max(totalCount[i], letterCount[i]);
            }
        }
        return totalCount;
    }

    private int[] countWordLetters(char[] chrs) {
        int[] count = new int[26];
        for (char c : chrs) {
            count[c - 'a']++;
        }
        return count;
    }
    // if the given word has fewer chars than the superWord, then that word is not universal
    private boolean isUniversalSubset(int[] letterCount, int[] joinedWords) {
        for (int i = 0; i < letterCount.length; i++) {
            if (joinedWords[i] > letterCount[i]) {
                return false;
            }
        }
        return true;
    }
}
