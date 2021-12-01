package com.ss.leetcode.LC2021.august;

import java.util.Arrays;
import java.util.Comparator;

public class LongestUncommonSubsequenceII {
    /**
     * Theory: if one string (abXYZ) has a unique substring inside eg: XYZ that no other string has, then why not considering all abXYZ string as unique/uncommon
     * So the problem becomes finding a string that has a unique combination of letters that no other string has. So the answer is one of the strings
     * and not one of the possible substrings obtained by combining the letters of a string.
     * Analyzing this, we observe that a larger String will be unique to a shorter String (eg: aaa contains aa but aa doesn't contain aaa).
     * Thus, is makes sense to sort the array based on length. If there is only one string with max length, that's unique to all the other.
     * If not, then start comparting the largest strings to the smallest ones
     *
     */
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(a -> a.length()));
        int maxUncommonLength = -1;
        // if the last string is also the longest, then it's unique!
        if (strs[strs.length - 1].length() != strs[strs.length -2].length()) {
            return strs[strs.length -1].length();
        }
        // if we found one maxUncommonLength then there is no point into checking anymore as the rest of strings will be shorter.
        for (int i = strs.length -1; i >= 0; i--) {
            boolean foundCommonSequence = false;
            for (int j = strs.length -1; j >=0; j--) {
                // i != j to avoid comparing the string with itself.
                if (i != j && isSubsequenceOf(strs[i], strs[j])) {
                    foundCommonSequence = true;
                    break;
                }
            }
            if (!foundCommonSequence) {
                maxUncommonLength = strs[i].length();
                break;
            }
        }
        return maxUncommonLength;
    }

    // verify if all characters from subsequence String are present in target String.
    // loop over each char in  target and use an index over subsequence String.
    // if all matched characters are found, then matchedCharacters == subsequence.length();
    private boolean isSubsequenceOf(String subsequence, String target) {
        int matchedCharacters = 0;
        for (int i = 0; i < target.length() && matchedCharacters < subsequence.length(); i++) {
            if (subsequence.charAt(matchedCharacters) == target.charAt(i)) {
                matchedCharacters++;
            }
        }
        return matchedCharacters == subsequence.length();
    }
}
