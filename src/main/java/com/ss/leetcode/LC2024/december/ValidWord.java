package com.ss.leetcode.LC2024.december;

public class ValidWord {
    // https://leetcode.com/problems/valid-word
    /** Algorithm
        1. Traverse word and for each letter: if is vowel, set vowel flag, else consonant flag.
        2. If current letter is not char or digit, return false.
        3. Return length > 2 and the 2 flags.
     */
    public boolean isValid(String word) {
        boolean hasConsonant = false;
        boolean hasVowel = false;
        boolean isVowel;
        char current;
        for (int i = 0; i < word.length(); i++) {
            current = word.charAt(i);
            if (current >= 'A' && current <= 'Z' || (current >= 'a' && current <= 'z')) {
                current = (current <= 'Z' ? (char)(current + 32) : current);
                isVowel = isVowel(current);
                hasVowel = hasVowel || isVowel;
                hasConsonant = hasConsonant || !isVowel;
            } else if (current < '0' || current > '9') {
                return false;
            }
        }
        return word.length() >= 3 && hasVowel && hasConsonant;
    }

    private boolean isVowel(char ch) {
        return switch (ch) {
            case 'a','e','i','o', 'u'  -> true;
            default -> false;
        };
    }
}
