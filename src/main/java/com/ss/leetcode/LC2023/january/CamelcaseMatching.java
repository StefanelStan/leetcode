package com.ss.leetcode.LC2023.january;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    // https://leetcode.com/problems/camelcase-matching
    /** Algorithm
        1. For each query, determine if it matches or not the pattern. Add its answer to the list
        2. Determine if a query matches a pattern
            - fail fast: if query is shorter than patter, return false
        3. Use 2 pointers to traverse query and pattern. (q and p) while q & q < query/pattern length
            - If query[q] == pattern[p] advance p index
            - else if query[q] is upperCase, return false immediately as this needs to match an uppercase pattern
        4. Outside the loop: if p index did not reach the end of patter, return false immediately
             If it did, then you have to traverse the query with q index and check if there is any upperCase
            character. If yes, then return false immediately.
        5. Return true by default.
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> camelMatch = new ArrayList<>(queries.length);
        char[] patternChars = pattern.toCharArray();
        for (String query : queries) {
            camelMatch.add(isMatching(query, patternChars));
        }
        return camelMatch;
    }

    private boolean isMatching(String query, char[] pattern) {
        if (query.length() < pattern.length) {
            return false;
        }
        int qIndex = 0, pIndex = 0;
        char ch;
        while(qIndex < query.length() && pIndex < pattern.length) {
            ch = query.charAt(qIndex);
            if (ch == pattern[pIndex]) {
                pIndex++;
            } else if (Character.isUpperCase(ch)) {
                return false;
            }
            qIndex++;
        }
        if (pIndex == pattern.length) {
            while(qIndex < query.length()) {
                if (Character.isUpperCase(query.charAt(qIndex))) {
                    return false;
                }
                qIndex++;
            }
        } else {
            return false;
        }
        return true;
    }
}
