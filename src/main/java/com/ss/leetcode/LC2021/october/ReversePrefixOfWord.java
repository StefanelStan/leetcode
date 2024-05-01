package com.ss.leetcode.LC2021.october;

public class ReversePrefixOfWord {
    // https://leetcode.com/problems/reverse-prefix-of-word/
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder stb = new StringBuilder(word.length());
        for (int from = index; from >= 0; from--) {
            stb.append(word.charAt(from));
        }
        stb.append(word, index + 1, word.length());
        return stb.toString();
    }

    public String reversePrefix2(String word, char ch) {
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
