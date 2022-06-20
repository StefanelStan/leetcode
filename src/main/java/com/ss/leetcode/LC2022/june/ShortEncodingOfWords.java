package com.ss.leetcode.LC2022.june;

import java.util.Arrays;
import java.util.Comparator;

public class ShortEncodingOfWords {
    // https://leetcode.com/problems/short-encoding-of-words/
    /** Algorithm
         1. The idea behind this is to detect if a word is included in the final sequence of another word
            eg: eg: mar is included in the atmar word (as ending), cd included in abcd.
         2. Looking from this perspective, we can realize that we need a suffix tree, which is basically
             a prefix tree when you insert the letters backwords.
            EG: mar , atmar -> reverse of these => ram - ramat. ram and ramat have the same prefix.
         3. Sort the array based on length of the words. We need to process the longest words first.
            Why ? Because if we process ramat, we will ahve 5 links: r -> a -> m -> a - > t.
            When we will process ram, we will detect that last m has other links, so this string is already included in some other string.
         4. Start inserting each word into the suffix tree OR in a prefix tree but in reverse letter order.
            - If you reach the last letter (or first) and there are no other links, then this is a new word, so it will need
            to be put as it is: word# (so word.length() + 1 size).
            - If you reach the end of the word and there are links from last letter, then this word is/can be included/part -termiantion of other,
            so it will contribute with 0 to the length of the encoded string.
     */
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(w -> w.length()));
        int totalSize = 0;
        Trie trie = new Trie();
        for (int i = words.length -1; i >=0; i--) {
            totalSize += trie.insert(words[i]);
        }
        return totalSize;
    }

    private static class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode currentNode = root;
            int i = word.length() -1;
            int size = 0;
            char ch;
            // we insert in reverse order to simulate a suffix tree.
            while (i > 0) {
                ch = word.charAt(i);
                if (!currentNode.containsKey(ch)) {
                    currentNode.put(ch, new TrieNode());
                }
                currentNode = currentNode.get(ch);
                i--;
            }
            // when reaching the last letter, check if there are links going out of it.
            //- If no, then it's a distinct word and will need its full length + 1
            // -If yes, then this word can be part of other words
            ch = word.charAt(0);
            if (!currentNode.containsKey(ch)) {
                currentNode.put(ch, new TrieNode());
                size = word.length() + 1;
            }
            return size;
        }

        private static class TrieNode {
            private static final int R = 26;
            private final TrieNode[] links;

            public TrieNode() {
                this.links = new TrieNode[R];
            }

            public boolean containsKey(char key) {
                return links[key - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }
        }
    }
}
