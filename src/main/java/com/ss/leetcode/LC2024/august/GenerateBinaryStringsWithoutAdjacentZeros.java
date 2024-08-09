package com.ss.leetcode.LC2024.august;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateBinaryStringsWithoutAdjacentZeros {
    // https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros
    /** Algorithm
        1. If you n == 1, return [0,1]
        2. Else, you need to build the list of strings for n-1.
        3. Supposing the list for n-1 has [x,y,z] strings. For current n, you have two append 0 and 1.
            - If the string x starts with 1, then this can be used with 0 and 1 as well: 1x and 0x
            - If the string x starts with 0, then this can only be used in conjunction with 1: 1x as using 0x will generate 2 consecutive 0s
        4. Recursively, build the list of n-1 and then append 0 or 1 to each string, depending if it starts with 0 or 1.
     */
    public List<String> validStrings(int n) {
        if (n == 1) {
            return List.of("0","1");
        }
        List<String> downstreamCombinations = validStrings(n - 1);
        List<String> combinations = new ArrayList<>();
        StringBuilder stb = new StringBuilder();
        for (String downstreamCombination : downstreamCombinations) {
            combinations.add(stb.append('1').append(downstreamCombination).toString());
            if (downstreamCombination.charAt(0) == '1') {
                stb.replace(0, 1, "0");
                combinations.add(stb.toString());
            }
            stb.setLength(0);
        }

        return combinations;
    }

    public List<String> validStrings2(int n) {
        Map<Integer, List<String>> combinations = combineStrings(n);
        List<String> strings = new ArrayList<>(combinations.get(0).size() + combinations.get(1).size());
        strings.addAll(combinations.get(0));
        strings.addAll(combinations.get(1));
        return strings;
    }

    private Map<Integer, List<String>> combineStrings(int n) {
        if (n == 1) {
            return Map.of(0, List.of("0"), 1, List.of("1"));
        }
        Map<Integer, List<String>> downstream = combineStrings(n-1);
        List<String> startWith0 = new ArrayList<>();
        List<String> startWith1 = new ArrayList<>();
        appendToList(startWith0, '0', downstream.get(1));
        appendToList(startWith1, '1', downstream.get(0));
        appendToList(startWith1, '1', downstream.get(1));
        return Map.of(0, startWith0, 1, startWith1);
    }

    private void appendToList(List<String> strings, char firstChar, List<String> suffixes) {
        StringBuilder stb = new StringBuilder();
        for (String suffix : suffixes) {
            stb.append(firstChar).append(suffix);
            strings.add(stb.toString());
            stb.setLength(0);
        }
    }
}
