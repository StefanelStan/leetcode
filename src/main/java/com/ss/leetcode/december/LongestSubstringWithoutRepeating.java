package com.ss.leetcode.december;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String string) {
        if (string.isEmpty()) {
            return 0;
        }
        if (string.length() ==1) {
            return 1;
        }

        int longest = 0;
        Set<Character> tempSet = new HashSet<>();
        for (int i = 0; i < string.length() - 1; i++) {
            tempSet.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (!tempSet.add(string.charAt(j))) {
                    if (tempSet.size() > longest) {
                        longest = tempSet.size();
                    }
                    tempSet.clear();
                    break;
                }
            }
            if (tempSet.size() > longest) {
                longest = tempSet.size();
            }
            tempSet.clear();
        }
        return longest;
        // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    }
}
