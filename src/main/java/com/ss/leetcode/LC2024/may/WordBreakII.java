package com.ss.leetcode.LC2024.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBreakII {
    // https://leetcode.com/problems/word-break-ii
    /** Algorithm
        1. Use a Trie to store the prefixes
        2. From s index 0 to n-1 try to walk on the trie and if you step on a final word, get the list of words from index +1
        3. If the call returns something, add current word to a list and return it. Else mark the position as bad
        4. Format and return the List from [0]
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>>[] sentences = new List[s.length()];
        boolean[] buildable = new boolean[s.length()];
        Arrays.fill(buildable, true);
        TrieNode root = buildPrefixTrie(wordDict);
        List<List<String>> buildSentences = buildSentences(s.toCharArray(), 0, root, buildable,sentences);
        return formatSentences(buildSentences);
    }

    private List<List<String>> buildSentences(char[] chars, int index, TrieNode root, boolean[] buildable, List<List<String>>[] sentences) {
        if (index == chars.length) {
            return Collections.emptyList();
        }
        if (!buildable[index]) {
            return null;
        }
        if (sentences[index] == null) {
            sentences[index] = searchInTrie(chars, index, root, buildable, sentences);
            if (sentences[index] == null) {
                buildable[index] = false;
            }
        }
        return sentences[index];
    }

    private List<List<String>> searchInTrie(char[] chars, int index, TrieNode root, boolean[] buildable, List<List<String>>[] sentences) {
        List<List<String>> build = null;
        TrieNode originalRoot = root;
        int right = index;
        StringBuilder stb = new StringBuilder();
        while (right < chars.length) {
            root = root.getNode(chars[right] - 'a');
            if (root == null) {
                break;
            }
            stb.append(chars[right]);
            if (root.isFinal) {
                String seq = stb.toString();
                List<List<String>> nextOnes = buildSentences(chars, right + 1, originalRoot, buildable, sentences);
                if (nextOnes != null) {
                    if (build == null) {
                        build = new ArrayList<>();
                    }
                    if (nextOnes.isEmpty()) {
                        build.add(List.of(seq));
                    } else {
                        for (List<String> chain : nextOnes) {
                            List<String> newChain = new ArrayList<>(1 + chain.size());
                            newChain.add(seq);
                            newChain.addAll(chain);
                            build.add(newChain);
                        }
                    }
                }
            }
            right++;
        }
        return build;
    }

    private List<String> formatSentences(List<List<String>> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> formatted = new ArrayList<>(sentences.size());
        StringBuilder stb = new StringBuilder();
        for (List<String> sentence : sentences) {
            stb.setLength(0);
            for (int i = 0; i < sentence.size() - 1; i++) {
                stb.append(sentence.get(i)).append(' ');
            }
            stb.append(sentence.getLast());
            formatted.add(stb.toString());
        }
        return formatted;
    }

    private TrieNode buildPrefixTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            addToTrie(root, word);
        }
        return root;
    }

    private void addToTrie(TrieNode root, String word) {
        int codePoint;
        for (int i = 0;  i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            root = root.addNode(codePoint);
        }
        root.isFinal = true;
    }

    private static class TrieNode {
        TrieNode[] nodes;
        boolean isFinal;
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
}
