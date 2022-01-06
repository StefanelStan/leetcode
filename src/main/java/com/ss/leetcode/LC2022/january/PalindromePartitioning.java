package com.ss.leetcode.LC2022.january;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    // https://leetcode.com/problems/palindrome-partitioning/
    public List<List<String>> partition(String s) {
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
