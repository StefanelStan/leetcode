package com.ss.leetcode.LC2022.january;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {
    // https://leetcode.com/problems/palindrome-partitioning/
    // DP PRO
    public List<List<String>> partition(String s) {
        List<List<String>>[] palindromes = new List[s.length()];
        return getPalindromes(s.toCharArray(), 0, palindromes);
    }

    private List<List<String>> getPalindromes(char[] chars, int index, List<List<String>>[] palindromes) {
        if (index == chars.length) {
            return Collections.emptyList();
        }
        if (palindromes[index] == null) {
            List<List<String>> build = new ArrayList<>();
            for (int right = index; right < chars.length; right++) {
                if (isPalindrome(chars, index, right)) {
                    List<List<String>> nextOnes = getPalindromes(chars, right + 1, palindromes);
                    build.addAll(mergePalindromes(new String(chars, index, (1 + right - index)), nextOnes));
                }
            }
            palindromes[index] = build;
        }
        return palindromes[index];
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left <= right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> mergePalindromes(String head, List<List<String>> nextOnes) {
        List<List<String>> merged = new ArrayList<>();
        if (nextOnes.isEmpty()) {
            merged.add(List.of(head));
        } else {
            for (List<String> nextChain : nextOnes) {
                List<String> newOne = new ArrayList<>(nextChain.size() + 1);
                newOne.add(head);
                newOne.addAll(nextChain);
                merged.add(newOne);
            }
        }
        return merged;
    }




    public List<List<String>> partition2(String s) {
        List<List<String>> partitions = new ArrayList<>();
        searchPartitions(s, 0, new ArrayList<>(), partitions);
        return partitions;
    }

    private void searchPartitions(String s, int start, List<String> palindromes, List<List<String>> partitions) {
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                List<String> newPalindromes = new ArrayList<>(palindromes);
                palindromes.add(s.substring(start, i + 1));
                if (i < s.length() - 1) {
                    searchPartitions(s, i + 1, newPalindromes, partitions);
                } else {
                    partitions.add(newPalindromes);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt((j--))) {
                return false;
            }
        }
        return true;
    }
}
