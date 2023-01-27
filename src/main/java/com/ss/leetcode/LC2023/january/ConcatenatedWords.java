package com.ss.leetcode.LC2023.january;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    // https://leetcode.com/problems/concatenated-words
    /** Algorithm
        1. One good solution is to build a Prefix Tree (Trie) and add ALL the words. This way we can search if
            any word from any point/index is actually made out of any word.
        2. For each word, look is possible matches/contatenations can be found
            EG: Trie contains bar, ten, bartender.
            Using a trie, we can look up the word bartender from any index from 0 to 8.
            a) bartender from index 0. We discover the word bar finishing at index 2 of bartender.
            b) we then look bartender from index 3: we discover ten
            c) we then look bartender from index 6
            here it fails because it cannot find any node in the trie linked to d.
        3. Understanding this, we still have to cover a DFS in case words overlap: eg: bar, bart, (these 2 words overlap)ender
            EG: bar, ten, bart, ender, bartender.
            a). search bartender from index 0. We discover bar. We now look bartender from index 3. We discover ten.
                Then looking bartender from index 6 we stop as d has null node
            b) HOWEVER, as it' BFS we do not stop at the first word: bar. We continue
                bartender from index 0 also finds bart. We then look bartender from index 4
                bartender from index 4: we find ender. At we are at the end of the word, the node is a final node and
                the from index > 0 (meaning there was already a word found), we conclude this is a concatenated word.
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> concatenatedWords = new ArrayList<>();
        Trie trie = buildTrie(words);
        for (String word : words) {
            boolean[] isConcatenated = {false};
            trie.searchForConcatenation(word.toCharArray(), 0, isConcatenated);
            if (isConcatenated[0]) {
                concatenatedWords.add(word);
            }
        }
        return concatenatedWords;
    }

    private Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        return trie;
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            char ch;
            for(int i = 0; i < word.length(); i++) {
                ch = word.charAt(i);
                current.addNode(ch);
                current = current.getNode(ch);
            }
            current.isWord = true;
        }

        public void searchForConcatenation(char[] chars, int from, boolean[] isConcatenated) {
            if (!isConcatenated[0]) {
                TrieNode current = root;
                for (int i = from; i < chars.length; i++) {
                    current = current.getNode(chars[i]);
                    if (current == null) {
                        break;
                    }
                    if (current.isWord) {
                        // if we are somewhere is the middle and we still didn't conclude if it's a concatenated word, we still have
                        // to search again from next index.
                        if (!isConcatenated[0]) {
                            searchForConcatenation(chars, i + 1, isConcatenated);
                        }
                    }
                }
                // if we have reached the end of the word, the current node in trie is a word node AND from > 0 (from > 0 means we
                // have arrived here being called from another recursion, meaning one word was already found),
                // then we have a contatenated word
                if (current != null && current.isWord && from > 0) {
                    isConcatenated[0] = true;
                }
            }
        }
    }

    private static class TrieNode {
        private static int R = 26;
        private boolean isWord;
        private TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[R];
        }

        private TrieNode getNode(char c) {
            return links[c - 'a'];
        }

        private void addNode(char c) {
            if(links[c - 'a'] == null) {
                links[c - 'a'] = new TrieNode();
            }
        }
    }
}
