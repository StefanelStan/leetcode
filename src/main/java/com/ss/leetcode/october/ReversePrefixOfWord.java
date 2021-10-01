package com.ss.leetcode.october;

public class ReversePrefixOfWord {
    // https://leetcode.com/problems/reverse-prefix-of-word/
    public String reversePrefix(String word, char ch) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                stb.append(word.charAt(i));
                stb.reverse();
                stb.append(word, i + 1, word.length());
                break;
            } else {
                stb.append(word.charAt(i));
            }
        }
        return stb.toString();
    }
}
