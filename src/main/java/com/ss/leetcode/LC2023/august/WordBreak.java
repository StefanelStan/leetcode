package com.ss.leetcode.LC2023.august;

import java.util.List;

public class WordBreak {
    // https://leetcode.com/problems/word-break
    /** Algorithm
        1. Use a Trie data structure to add all the words from dictionary.
        2. Once the dictionary trie has been build, walk over each letter from String s keeping an index.
        3. In case you reach a terminal step/node - found a word from word trie, then recursively call this method,
            starting to walk again from the root node but from the index + 1 of String.
        4. It is possible that you might arrive to same index of S from two different positions, so keep
            a Boolean[] validSegments (DP) to mark if a step combinations has been already done
            - EG: s = "aaac" and dictionary is "a", "aa".
            - word0:(a) index 0, found word a, search again from index 1. index 1, found a -> jump to index 2.
                Compute index 2 will returns false;
            - word1:(aa) Found word1, jump to index 2.
                but we have already calculated combinations of index 2 above.
        5. For each set of index-searched combinations keep a validSegments[] boolean flag to save precomputing time.
        6. Return true if your helper method is ever called with an index >= s.length().
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chrs = s.toCharArray();
        Boolean[] validSegments = new Boolean[chrs.length];
        boolean[] canBreak = {false};
        Trie trie = addDictionaryToTrie(wordDict);
        searchSegments(chrs, 0, trie, validSegments, canBreak);
        return canBreak[0];
    }

    private boolean searchSegments(char[] chrs, int index, Trie trie, Boolean[] validSegments, boolean[] canBreak) {
        if (index >= chrs.length) {
            return canBreak[0] = true;
        }
        if (validSegments[index] != null) {
            return validSegments[index];
        }
        Trie current = trie;
        int start = index;
        boolean segmentFound = false;
        while (start < chrs.length && current != null && !segmentFound && !canBreak[0]) {
            current = current.getNode(chrs[start]);
            if (current != null && current.isWord()) {
                segmentFound = searchSegments(chrs, start + 1, trie, validSegments, canBreak);
            }
            start++;
        }
        return validSegments[index] = segmentFound;
    }

    private Trie addDictionaryToTrie(List<String> wordDict) {
        Trie root = new Trie();
        Trie current;
        char ch;
        for (String word : wordDict) {
            current = root;
            for (int i = 0; i < word.length(); i++) {
                ch = word.charAt(i);
                if (current.getNode(ch) == null) {
                    current.addNode(ch);
                }
                current = current.getNode(ch);
            }
            current.setWord();
        }
        return root;
    }

    private static class Trie {
        private final Trie[] nodes;
        private boolean isWord;

        public Trie() {
            nodes = new Trie[26];
        }

        public void addNode(char c) {
            nodes[c - 'a'] = new Trie();
        }

        public Trie getNode(char c) {
            return nodes[c - 'a'];
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord() {
            isWord = true;
        }
    }
}
