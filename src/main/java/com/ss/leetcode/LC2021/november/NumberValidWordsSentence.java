package com.ss.leetcode.LC2021.november;

public class NumberValidWordsSentence {
    // https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
    public int countValidWords(String sentence) {
        int validWords=0;
        int start = 0;
        boolean insideWord = false;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                if (insideWord) {
                    insideWord = false;
                    if (isOk(sentence, start, i-1)) {
                        validWords++;
                    }
                }
            } else if (!insideWord) {
                insideWord = true;
                start = i;
            }
        }
        if (sentence.charAt(sentence.length()-1) != ' ' && isOk(sentence, start, sentence.length()-1)) {
            validWords++;
        }
        return validWords;
    }

    private boolean isOk(String s, int start, int end) {
        return hasGoodLetters(s, start, end) && hasGoodHyphen(s, start, end)
            && hasGoodPunctuation(s, start, end);
    }

    private boolean hasGoodLetters(String s, int start, int end) {
        for (; start <= end; start++) {
            if (isDigit(s.charAt(start))) {
                return false;
            }
        }
        return true;
    }

    private boolean hasGoodHyphen(String s, int start, int end) {
        int occurances = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '-') {
                if (i == start || i == end) {
                    return false;
                }
                if (isLetter(s.charAt(i-1)) && isLetter(s.charAt(i+1))) {
                    if (++occurances > 1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasGoodPunctuation(String s, int start, int end) {
        for (; start <= end; start++) {
            if ((s.charAt(start) == '!' || s.charAt(start) == '.' || s.charAt(start) == ',') && start != end) {
                return false;
            }
        }
        return true;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
