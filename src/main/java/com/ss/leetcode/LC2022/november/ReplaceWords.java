package com.ss.leetcode.LC2022.november;

import java.util.List;

public class ReplaceWords {
    // https://leetcode.com/problems/replace-words/
    public String replaceWords(List<String> dictionary, String sentence2) {
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
