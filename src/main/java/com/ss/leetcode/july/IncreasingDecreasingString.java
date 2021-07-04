package com.ss.leetcode.july;

import java.util.Map;
import java.util.TreeMap;

public class IncreasingDecreasingString {
    // https://leetcode.com/problems/increasing-decreasing-string/
    public String sortString(String s) {
        TreeMap<Character, Integer> chars = new TreeMap<>();

        char[] answer = new char[s.length()];
        int[] index = new int[1];
        for (int i = 0; i < s.length(); i++) {
            chars.merge(s.charAt(i), 1, Integer::sum);
        }

        while (index[0] < answer.length) {
            performStepsOneToThree(index, answer, chars);
            performStepsFourToSix(index, answer, chars);
        }
        return new String(answer);
    }

    private void performStepsOneToThree(int[] index, char[] answer, TreeMap<Character, Integer> chars) {
        answer[index[0]] = chars.firstEntry().getKey();
        index[0]++;
        int newValue = chars.firstEntry().getValue() - 1;
        if (newValue > 0) {
            chars.replace(chars.firstEntry().getKey(), newValue);
        } else {
            chars.remove(chars.firstEntry().getKey());
        }
        Map.Entry<Character, Integer> entry = chars.higherEntry(answer[index[0] - 1]);
        while (entry != null) {
            loopAndInsert(index, answer, chars, entry);
            entry = chars.higherEntry(answer[index[0] - 1]);
        }
    }

    private void performStepsFourToSix(int[] index, char[] answer, TreeMap<Character, Integer> chars) {
        if (chars.lastEntry() != null) {
            answer[index[0]] = chars.lastEntry().getKey();
            index[0]++;
            int newValue = chars.lastEntry().getValue() - 1;
            if (newValue > 0) {
                chars.replace(chars.lastEntry().getKey(), newValue);
            } else {
                chars.remove(chars.lastEntry().getKey());
            }
            Map.Entry<Character, Integer> entry = chars.lowerEntry(answer[index[0] - 1]);
            while (entry != null) {
                loopAndInsert(index, answer, chars, entry);
                entry = chars.lowerEntry(answer[index[0] - 1]);
            }
        }
    }

    private void loopAndInsert(int[] index, char[] answer, TreeMap<Character, Integer> chars, Map.Entry<Character,
            Integer> entry) {
        int newValue;
        answer[index[0]] = entry.getKey();
        index[0]++;
        newValue = entry.getValue() - 1;
        if (newValue > 0) {
            chars.replace(entry.getKey(), newValue);
        } else {
            chars.remove(entry.getKey());
        }
    }
}
