package com.ss.leetcode.LC2021.july;

public class CheckIfAllCharactersEqualOccurrences {
    // https://leetcode.com/contest/biweekly-contest-57/problems/check-if-all-characters-have-equal-number-of-occurrences/
    public boolean areOccurrencesEqual(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int[] occurances = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            occurances[s.charAt(i)]++;
        }

        int times = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (occurances[i] > 0) {
                if (times == 0) {
                    times = occurances[i];
                } else if (times != occurances[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
