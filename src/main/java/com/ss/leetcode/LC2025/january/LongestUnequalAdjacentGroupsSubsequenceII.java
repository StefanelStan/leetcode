package com.ss.leetcode.LC2025.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestUnequalAdjacentGroupsSubsequenceII {
    // https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<Word>[] groupedByLength = groupByLength(words, groups);
        List<Word> longest = new ArrayList<>();
        for (List<Word> wordList : groupedByLength) {
            if (wordList != null) {
                List<Word> candidate = findLongestSubsequence(wordList);
                if (candidate.size() > longest.size()) {
                    longest = candidate;
                }
            }
        }
        List<String> subseq =  new ArrayList<>(longest.size());
        for (Word w : longest) {
            subseq.add(new String(w.chars));
        }
        return subseq;
    }

    private List<Word> findLongestSubsequence(List<Word> words) {
        Map<Integer, List<Word>>[] longest = new Map[words.size()];
        for (int i = 0; i < words.size(); i++) {
            longest[i] = new HashMap<>();
        }
        return pickWords(words, 0, null, longest);
    }

    private List<Word> pickWords(List<Word> words, int index, Word lastPicked, Map<Integer, List<Word>>[] longest) {
        if (index == words.size()) {
            return new ArrayList<>();
        }
        int hashCode = Arrays.hashCode(lastPicked == null ? null : lastPicked.chars);
        List<Word> result = longest[index].get(hashCode);
        if (result == null) {
            // skip
            result = new ArrayList<>();
            List<Word> candidate1 = pickWords(words, index + 1, lastPicked, longest);
            // pick
            if (canPickWord(lastPicked, words.get(index))) {
                List<Word> candidate2 = pickWords(words, index + 1,  words.get(index), longest);
                if (candidate2.size() >= candidate1.size()) {
                    result.add(words.get(index));
                    result.addAll(candidate2);
                } else {
                    result.addAll(candidate1);
                }
            } else {
                result.addAll(candidate1);
                return result;
            }
            longest[index].put(hashCode, result);
        }
        return result;
    }

    private boolean canPickWord(Word lastPicked, Word nextToPick) {
        return lastPicked == null || (lastPicked.group != nextToPick.group && hammingDistance(lastPicked.chars, nextToPick.chars) == 1);
    }

    private int hammingDistance(char[] chars1, char[] chars2) {
        int distance = 0;
        for (int i = 0; i < chars1.length && distance < 2; i++) {
            if (chars1[i] != chars2[i]) {
                distance++;
            }
        }
        return distance;
    }

    private List<Word>[] groupByLength(String[] words, int[] groups) {
        List<Word>[] groupedByLength = new List[11];
        for (int i = 0; i < words.length; i++) {
            if (groupedByLength[words[i].length()] == null) {
                groupedByLength[words[i].length()] = new ArrayList<>();
            }
            groupedByLength[words[i].length()].add(new Word(words[i].toCharArray(), groups[i]));
        }
        return groupedByLength;
    }

    private record Word(char[] chars, int group) {}
}
