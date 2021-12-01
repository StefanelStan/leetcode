package com.ss.leetcode.LC2021.november;

import java.util.Arrays;
import java.util.LinkedList;

public class IteratorForCombination {
    // https://leetcode.com/problems/iterator-for-combination/
    LinkedList<String> combinations = new LinkedList<>();
    public IteratorForCombination(String characters, int combinationLength) {
        char[] chars = characters.toCharArray();
        Arrays.sort(chars);
        generateCombinations(chars, 0, combinationLength, new StringBuilder(), combinations);
    }

    private void generateCombinations(char[] chars, int start, int len, StringBuilder stb, LinkedList<String> combinations) {
        if (stb.length() == len) {
            combinations.add(stb.toString());
            return;
        }
        if (stb.length() > len) {
            return;
        }
        for (int i = start; i < chars.length; i++) {
            stb.append(chars[i]);
            generateCombinations(chars, i + 1, len, stb, combinations);
            stb.deleteCharAt(stb.length() -1);
        }
    }

    public String next() {
        return combinations.removeFirst();
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}
