package com.ss.leetcode.LC2023.september;

import java.util.Arrays;

public class ExtraCharactersInAString {
    // https://leetcode.com/problems/extra-characters-in-a-string
    /** Algorithm
        1. Use a Trie to insert all the dictionary words
        2. For each letter in string s, we have two options: pick that letter and try to walk over the Trie OR
            ignore that letter, skip it and try to see if you can walk on the Trie starting with the next letter.
        3. Use an int[] minExtra of size s.length() to cache the intermediary results of walking on the path
        4. For each index, (0, s.length(), if it was NOT walked already, walk it and determine the best/MIN score)
            - EG: "abcdefg", ["abc","def"];
            - if we walk from index 0, we see that we find the word "abc". Thus, the next walk will start from index 3.
            - at index 3 we walk and we see that we find word def. So we jump to index 6.
            - at index 6 we have g, which is NOT in trie.
            Thus, for index 0, 3 and 6 we have the cost [1,MAX,MAX,1,MAX,MAX,1]
        5. Not picking. If we decide to NOT pick current index, we jump to index 1 and we try to walk.
            - skipping fast-forward, if we keep skipping, we will reach index 3, which was already calculated, so we make use of that.
     */
    private static final int NOT_VISITED = 100;
    public int minExtraChar(String s, String[] dictionary) {
        Trie root = insertDictionary(dictionary);
        int[] minExtra = new int[s.length()];
        Arrays.fill(minExtra, NOT_VISITED);
        return visitString(s.toCharArray(), 0, minExtra, root);
    }

    private int visitString(char[] chars, int index, int[] minExtra, Trie root) {
        if (index >= chars.length) {
            return 0;
        }
        if (minExtra[index] == NOT_VISITED) {
            // pick
            int start = index;
            Trie rootCopy = root;
            while(start < chars.length && rootCopy.hasNode(chars[start] - 'a')) {
                rootCopy = rootCopy.getNode(chars[start] - 'a');
                if (rootCopy.isWord()) {
                    minExtra[index] = Math.min(minExtra[index], visitString(chars, start + 1, minExtra, root));
                }
                start++;
            }

            //not pick
            minExtra[index] = Math.min(minExtra[index], 1 + visitString(chars, index +  1, minExtra, root));
        }
        return minExtra[index];
    }

    private Trie insertDictionary(String[] dictionary) {
        Trie root = new Trie(), temp;
        int codePoint, i;
        for (String word : dictionary) {
            temp = root;
            i = 0;
            for (; i < word.length(); i++) {
                codePoint = word.charAt(i) - 'a';
                if (!temp.hasNode(codePoint)) {
                    temp = temp.addNode(codePoint);
                } else {
                    temp = temp.getNode(codePoint);
                }
            }
            temp.setWord();
        }
        return root;
    }

    private static class Trie {
        private final Trie[] nodes;
        private boolean isWord;

        public Trie() {
            nodes = new Trie[26];
        }

        public Trie getNode(int index) {
            return nodes[index];
        }

        public boolean hasNode(int index) {
            return nodes[index] != null;
        }

        public Trie addNode(int index) {
            nodes[index] = new Trie();
            return nodes[index];
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord() {
            isWord = true;
        }
    }
}
