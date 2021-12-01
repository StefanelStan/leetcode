package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCasePermutation {
    // https://leetcode.com/problems/letter-case-permutation/
    public List<String> letterCasePermutation(String s) {
        List<Integer> letterPos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 57) {
                letterPos.add(i);
            }
        }
        if (letterPos.isEmpty()) {
            return List.of(s);
        }
        return calculatePermutations(s, letterPos, 0, letterPos.size() - 1)
            .stream().map(permutation -> new String(permutation)).collect(Collectors.toList());
    }

    private List<char[]> calculatePermutations(String s, List<Integer> letterPos, int start, int end) {
        List<char[]> newCombinations = new ArrayList<>();
        if (start < end) {
            List<char[]> rightCombinations = calculatePermutations(s, letterPos, start + 1, end);
            newCombinations.addAll(rightCombinations);
            char flippedChar = flipChar(s.charAt(letterPos.get(start)));
            for (char[] combination : rightCombinations) {
                char[] newCombination = new char[combination.length];
                System.arraycopy(combination, 0, newCombination, 0, combination.length);
                newCombination[letterPos.get(start)] = flippedChar;
                newCombinations.add(newCombination);
            }
        } else {
            char[] original = s.toCharArray();
            original[letterPos.get(start)] = flipChar(s.charAt(letterPos.get(start)));
            newCombinations.add(original);
            newCombinations.add(s.toCharArray());
        }
        return newCombinations;
    }

    private char flipChar(char ch) {
        return ch >= 'a' ? (char)(ch -32) : (char)(ch + 32);
    }
}
