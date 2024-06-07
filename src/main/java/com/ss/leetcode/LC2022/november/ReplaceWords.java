package com.ss.leetcode.LC2022.november;

import java.util.List;

public class ReplaceWords {
    // https://leetcode.com/problems/replace-words/
    /** Algorithm
     1. Split the sentence into chunks by " " (space delimiter)
     2. For each chunk (word) apart from last one you will append it's replacement and " ".
     For last word, you will just append the replacement.
     3. Create a Trie for dictionary
     4. For each word, walk on the trie. If you encounter a node that is word, return the substring (0, index+1)
     5. If you step on a null node OR you reach the end of word, then append the whole word as it is.
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] chunks = sentence.split(" ");
        TrieNode root = buildTrie(dictionary);
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < chunks.length - 1; i++) {
            stb.append(findReplacement(chunks[i], root));
            stb.append(' ');
        }
        stb.append(findReplacement(chunks[chunks.length - 1], root));
        return stb.toString();
    }

    private String findReplacement(String word, TrieNode root) {
        int index = 0, codePoint;
        for (; index < word.length(); index++) {
            codePoint = word.charAt(index) - 'a';
            root = root.getNode(codePoint);
            if (root == null) {
                index = word.length();
            } else if (root.isWord) {
                index++;
                break;
            }
        }
        return index >= word.length() ? word : word.substring(0, index);
    }

    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            addToTrie(word, root);
        }
        return root;
    }

    private void addToTrie(String word, TrieNode root) {
        int codePoint;
        for (int i = 0; i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            root = root.addNode(codePoint);
        }
        root.isWord = true;
    }

    private static class TrieNode {
        TrieNode[] nodes;
        boolean isWord;
        public TrieNode() {
            nodes = new TrieNode[26];
        }

        private TrieNode addNode(int codePoint) {
            if (nodes[codePoint] == null) {
                nodes[codePoint] = new TrieNode();
            }
            return nodes[codePoint];
        }

        private TrieNode getNode(int codePoint) {
            return nodes[codePoint];
        }
    }



    public String replaceWords2(List<String> dictionary, String sentence2) {
        char[] sentence = sentence2.toCharArray();
        StringBuilder replacedWord = new StringBuilder(1000);
        Trie root = buildDictionary(dictionary);
        int rootEndingIndex = -1;
        for (int i = 0; i < sentence.length;) {
            rootEndingIndex = findRoot(root, sentence, i);
            if (rootEndingIndex != -1) {
                appendSection(replacedWord, sentence, i, rootEndingIndex);
                i = getEndingWordPosition(sentence, rootEndingIndex) + 2;
            } else {
                rootEndingIndex = getEndingWordPosition(sentence, i);
                appendSection(replacedWord, sentence, i, rootEndingIndex);
                i = rootEndingIndex + 2;
            }
        }
        replacedWord.setLength(replacedWord.length() - 1);
        return replacedWord.toString();
    }

    private int findRoot(Trie root, char[] sentence, int currentPos) {
        if (currentPos >= sentence.length || sentence[currentPos] == ' ' || !root.contains(sentence[currentPos])) {
            return -1;
        }
        Trie nextNode = root.getNode(sentence[currentPos]);
        if (nextNode.isWord) {
            return currentPos;
        } else {
            return findRoot(nextNode, sentence, currentPos + 1);
        }
    }

    private int getEndingWordPosition(char[] sentence, int start) {
        while(start < sentence.length && sentence[start] != ' ') {
            start++;
        }
        return start - 1;
    }

    private void appendSection(StringBuilder stb, char[] sentence, int start, int end) {
        while(start <= end) {
            stb.append(sentence[start++]);
        }
        stb.append(' ');
    }

    private Trie buildDictionary(List<String> dictionary) {
        Trie root = new Trie();
        for (String word : dictionary) {
            addToTrie(root, word);
        }
        return root;
    }

    private void addToTrie(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            root = root.addChar(word.charAt(i));
        }
        root.isWord = true;
    }

    private static class Trie {
        private static final int SIZE = 26;
        boolean isWord;
        Trie[] nodes;

        public Trie() {
            nodes = new Trie[SIZE];
        }

        public boolean contains(char c) {
            return nodes[c - 'a'] != null;
        }

        public Trie addChar(char c) {
            if (!contains(c)) {
                nodes[c - 'a'] = new Trie();
            }
            return nodes[c - 'a'];
        }

        public Trie getNode(char c) {
            return nodes[c - 'a'];
        }
    }
}
