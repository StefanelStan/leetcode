package com.ss.leetcode.LC2025.february;

import java.util.ArrayList;
import java.util.List;

public class EncryptAndDecryptStrings {
    /** Algorithm
        1. Create a String[26] keysToValues that stores the mapping of char key to value. Use this to encrypy each letter of word.
        2. Use a List[][] valuesToKeys to store each value [c1,c2] to its corresponding charcter.
            - This way you can find to which char a value "ab" corresponds
        3. Put all the words of the dictionary in a Trie.
        4. To Decrypt:
            - apply DFS for each pair of 2 letters of word2.
            - get the lists of keys for that pair(value) and if trie contains entry,step on that node. Stop when you reach null node or end of word2.
            - if the final node is a word, return 1.
     */
    private String[] keysToValues;
    private List<Character>[][] valuesToKeys;
    private TrieNode root;

    public EncryptAndDecryptStrings(char[] keys, String[] values, String[] dictionary) {
        setKeysAndValues(keys, values);
        setRoot(dictionary);
    }

    private void setKeysAndValues(char[] keys, String[] values) {
        keysToValues = new String[26];
        valuesToKeys = new List[26][26];
        int first, second;
        for (int i = 0; i < keys.length; i++) {
            keysToValues[keys[i] - 'a'] = values[i];
            first = values[i].charAt(0) - 'a';
            second = values[i].charAt(1) - 'a';
            if (valuesToKeys[first][second] == null) {
                valuesToKeys[first][second] = new ArrayList<>();
            }
            valuesToKeys[first][second].add(keys[i]);
        }
    }

    private void setRoot(String[] dictionary) {
        root = new TrieNode();
        for (String word : dictionary) {
            addToRoot(root, word);
        }
    }

    private void addToRoot(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            root = root.addNode(word.charAt(i) - 'a');
        }
        root.setWord();
    }

    public String encrypt(String word1) {
        int codePoint;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            codePoint = word1.charAt(i) - 'a';
            if (keysToValues[codePoint] != null) {
                stb.append(keysToValues[codePoint]);
            } else {
                return "";
            }
        }
        return stb.toString();
    }

    public int decrypt(String word2) {
        return word2.length() % 2 == 1 ? 0 : findDecryptedWords(word2.toCharArray(), 0, root);
    }

    private int findDecryptedWords(char[] chars, int index, TrieNode rootNode) {
        if (index == chars.length) {
            return rootNode.isWord() ? 1 : 0;
        }
        int count = 0;
        if (valuesToKeys[chars[index] - 'a'][chars[index + 1] - 'a'] == null) {
            return 0;
        }
        for (char c : valuesToKeys[chars[index] - 'a'][chars[index + 1] - 'a']) {
            if (rootNode.getNode(c - 'a') != null) {
                count += findDecryptedWords(chars, index + 2, rootNode.getNode(c - 'a'));
            }
        }
        return count;
    }

    private static class TrieNode {
        TrieNode[] nodes;
        boolean isWord;

        public TrieNode() {
            this.nodes = new TrieNode[26];
        }

        public TrieNode addNode(int codePoint) {
            if (nodes[codePoint] == null) {
                nodes[codePoint] = new TrieNode();
            }
            return nodes[codePoint];
        }

        public TrieNode getNode(int codePoint) {
            return nodes[codePoint];
        }

        public void setWord() {
            isWord = true;
        }

        public boolean isWord() {
            return isWord;
        }
    }
}
