package com.ss.leetcode.LC2024.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsOfSpecialEquivalentStrings {
    // https://leetcode.com/problems/groups-of-special-equivalent-strings
    /** Algorithm
        1. Two words are equivalent the type and count of their even index letters are identical, but also their odd index letters.
        2. EG: "abcd","cdab"
            - "abcd" even index: [a,c], odd Index: [b,d]
            - "cdab" even index: [c,a], odd index: [d,b]
        3. Use in int[52] to count the number of letters of even and odd indixes
            - even index letters a-z will be stored in [0,25] and odd ones [26-51]
            (basically letter - 'a' + 26 => shift by 26 positions)
            - EG: "abcd" -> [1,0,1,0...,0,1(the b on index 1),0,1(d on index 3),0,0..0]
        4. Use a Set<Integer> and Arrays.hashCode(int[52]) the signature
        5. Return the size of set.
     */
    public int numSpecialEquivGroups(String[] words) {
        Set<Integer> groups = new HashSet<>();
        for (String word : words) {
            groups.add(getSignature(word));
        }
        return groups.size();
        // return Arrays.stream(words).map(this::getSignature).collect(Collectors.toSet()).size();
    }

    private int getSignature(String word) {
        int[] letterCount = new int[52];
        int codePoint, evenOddShift;
        for (int i = 0; i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            evenOddShift = i % 2 == 0 ? 0 : 26;
            letterCount[codePoint + evenOddShift]++;
        }
        return Arrays.hashCode(letterCount);
    }
}
