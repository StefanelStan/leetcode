package com.ss.leetcode.LC2022.february;

public class CountWordsObtainedAfterAddingALetter {
    /** Algorithm
         1. As the task is looking for anagrams (shuffled letters in a word), we can convert this into a
             ordered array of letters.
             EG: searching for "tak"would mean searching for "akt". This can use used to map the word to a set of
             boolean[] letters, there letters[0] = true (a -a), letters[k] = true (k-a) and letters[19] = true (t-a)
         2. Applying #1, build the Trie (SortedTrie) of start words, sorted/mapped from boolean[] letter count/presence.
             For quick response, also include a size (sizes[]) of each containing word.
             If trie sizes[17] is false, then don't spend time going through the trie to search for that length of word.
         3. For each targetWord, count/map the letters and try to see if SortedTrie contains any subset of length  -1.
             EG: targetWord = "abcd" => letters[] = [true, true, true, true, false, false, false].
             For simplicity let's trim it to [true, true, true, true].
             Looping through this, by turn, flip each index to false and see if the SortedTrie contains it.
             Loop1: [false, true, true, true]
             Loop2: [true, false, true, true]
             Loop3: [true, true, false, true]
             Loop4: [true, true, true, false].
            Return immediately 1 if any of the loop/search contains this sequence/word or 0 at the end.
     */
    public int wordCount(String[] startWords, String[] targetWords) {
        int wordCount = 0;
        SortedTrie sortedTrie = new SortedTrie();
        // insert start words in trie
        for (String startWord : startWords) {
            sortedTrie.insert(getLetters(startWord), startWord.length());
        }
        // for each targetWord, find if trie contains any combination of targetWord.length() -1;
        for (String targetWord : targetWords) {
            wordCount += getCountOf(targetWord, sortedTrie);
        }
        return wordCount;
    }

    private int getCountOf(String targetWord, SortedTrie sortedTrie) {
        int count = 0;
        boolean[] letterCount = getLetters(targetWord);
        letterCount[targetWord.charAt(0) - 'a'] = false;
        int length = targetWord.length() -1;
        // flip the first char of targetWord to false. Do it outside forLoop to avoid checking i = 0 each time
        if (sortedTrie.search(letterCount, length)) {
            return 1;
        }
        for (int i = 1; i < targetWord.length(); i++) {
            letterCount[targetWord.charAt(i -1) - 'a'] = true;
            letterCount[targetWord.charAt(i) - 'a'] = false;
            if (sortedTrie.search(letterCount, length)) {
                return 1;
            }
        }
        return count;
    }

    // return a boolean[] for each letter of the word.
    private boolean[] getLetters(String startWord) {
        boolean[] letters = new boolean[26];
        for (int i = 0; i < startWord.length(); i++) {
            letters[startWord.charAt(i) - 'a'] = true;
        }
        return letters;
    }

    // Build a sorted trie for each word: "cab" will be mapped as "abc" by default,
    // since we are passing a mapped array of chars/positions
    static class SortedTrie {
        private final TrieNode root;
        private final boolean[] wordLengths;

        public SortedTrie() {
            root = new TrieNode();
            wordLengths = new boolean[26];
        }

        private void insert(boolean[] word, int size) {
            TrieNode current = root;
            wordLengths[size] = true;
            for (int i = 0; i < word.length; i++) {
                if (word[i]) {
                    if(!current.contains(i)) {
                        current.put(i, new TrieNode());
                    }
                    current = current.get(i);
                }
            }
            current.setEnd();
        }

        private boolean search(boolean[] word, int size) {
            if (!wordLengths[size]) {
                return false;
            }
            TrieNode prefix = getPrefix(word);
            return prefix != null && prefix.isEnd();
        }

        private TrieNode getPrefix(boolean[] word) {
            TrieNode current = root;
            for (int i = 0; i < word.length && current != null; i++) {
                if (word[i]) {
                    current = current.get(i);
                }
            }
            return current;
        }

        private static class TrieNode {
            private static final int R = 26;
            private final TrieNode[] links;
            private boolean isEnd;

            public TrieNode() {
                this.links = new TrieNode[R];
            }

            private boolean contains(int idx) {
                return links[idx] != null;
            }

            private TrieNode get(int idx) {
                return links[idx];
            }

            private void put(int idx, TrieNode node) {
                links[idx] = node;
            }

            public void setEnd() {
                this.isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }
    }
}
