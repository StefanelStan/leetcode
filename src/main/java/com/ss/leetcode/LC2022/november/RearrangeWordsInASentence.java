package com.ss.leetcode.LC2022.november;

import java.util.PriorityQueue;

public class RearrangeWordsInASentence {
    // https://leetcode.com/problems/rearrange-words-in-a-sentence/
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        if (words.length == 1) {
            return words[0];
        }
        words[0] = Character.toLowerCase(words[0].charAt(0)) + words[0].substring(1);
        StringBuilder stb = new StringBuilder(text.length());
        PriorityQueue<ArrangedWord> pq = new PriorityQueue<>((a, b) -> a.word.length() == b.word.length() ? a.order - b.order : a.word.length() - b.word.length());
        for (int i = 0; i < words.length; i++) {
            pq.add(new ArrangedWord(words[i], i));
        }
        String current = pq.poll().word;
        current = Character.toUpperCase(current.charAt(0)) + current.substring(1);
        stb.append(current);
        stb.append(' ');
        for (int i = 0; i < words.length - 2; i++) {
            stb.append(pq.poll().word);
            stb.append(' ');
        }
        stb.append(pq.poll().word);
        return stb.toString();
    }

    private static class ArrangedWord {
        String word;
        int order;

        public ArrangedWord(String word, int order) {
            this.word = word;
            this.order = order;
        }
    }
}
