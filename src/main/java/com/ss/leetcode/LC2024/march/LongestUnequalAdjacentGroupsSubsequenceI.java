package com.ss.leetcode.LC2024.march;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    // https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i
    /** Algorithm
        1. Use an int lastAddedGroup to keep track of the tail/last added string (group) to answer
        2. Iterate with i and if currentGroup != lastAddedGroup
            - add word to answer
        - set lastAddedGroup to currentGroup.
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> longest = new ArrayList<>();
        int lastAddedGroup = -1;
        for (int i = 0; i < groups.length; i++) {
            if(groups[i] != lastAddedGroup) {
                lastAddedGroup = groups[i];
                longest.add(words[i]);
            }
        }
        return longest;
    }
}
