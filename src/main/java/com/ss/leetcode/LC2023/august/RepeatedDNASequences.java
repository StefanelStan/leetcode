package com.ss.leetcode.LC2023.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    // https://leetcode.com/problems/repeated-dna-sequences
    /** Algorithm
        1. If length is < 10, return empty list
        2. Use two sets: allSequences and duplicates.
        3. For each substring [i,i+10] (while i <= length - 10), add it to allSequences.
            If the result is false (not added => means it exists already), add it to duplicates set.
        4. Return new Array of duplicates.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return Collections.emptyList();
        }
        Set<String> allSequences = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        String sequence;
        for (int i = 0; i <= s.length()-10; i++) {
            sequence = s.substring(i, i+10);
            if (!allSequences.add(sequence)) {
                duplicates.add(sequence);
            }
        }
        return new ArrayList<>(duplicates);
    }
}
