package com.ss.leetcode.LC2022.october;

import java.util.LinkedList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {
    // https://leetcode.com/problems/words-within-two-edits-of-dictionary/
    /** Algorithm
         1. Problem can be solved via a more complex Trie with recursion, passing the query, index and nr of current edits.                However, due to small input length, a brute force can also work.
         2. Convert the String[] dictionary into a char[][].
            Each word of dictionary will be traversed n times; char[] provides faster access than string.charAt().
         3. For each query, try to see if char[][] dictionary can contain any edited form of it.
         4. In a separate method, iterate over each dictionary word and see if the word and query can match.
             Iterate over each letter of word and query. If mismatches > 2 return false immediately and true otherwise.
             If returned true, stop the loop, add the query to the answer and move to next query.
         5. Return the list with the answers.
     */
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> edits = new LinkedList<>();
        char[][] dictionaryLetters = getDictionaryLetters(dictionary);
        for (String query : queries) {
            if (canBeEdited(query.toCharArray(), dictionaryLetters)) {
                edits.add(query);
            }
        }
        return edits;
    }

    private char[][] getDictionaryLetters(String[] dictionary) {
        char[][] letters = new char[dictionary.length][dictionary[0].length()];
        for (int i = 0; i < dictionary.length; i++) {
            System.arraycopy(dictionary[i].toCharArray(), 0, letters[i], 0, dictionary[i].length());
        }
        return letters;
    }

    private boolean canBeEdited(char[] query, char[][] dictionaryLetters) {
        for (char[] word : dictionaryLetters) {
            if(canBeEdited(query, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean canBeEdited(char[] query, char[] word) {
        int edits = 0;
        for (int i = 0; i < query.length && edits < 3; i++) {
            if (query[i] != word[i]) {
                edits++;
            }
        }
        return edits < 3;
    }
}
