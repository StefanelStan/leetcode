package com.ss.leetcode.LC2024.december;

public class LexicographicallySmallestStringAfterOperationsWithConstraint {
    // https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint
    /** Algorithm
        1. The smallest lexic string starts with lowest chars (a) first
        2. Apply a greedy algorithm, trying to lower the first chars while k allows it.
        3. Traverse from first :
            - if k == 0, then you cannot do any modification; append the current letter as it is
            - else, figure out the min distance from current letter to a : current - 'a' or 123 - current.
            - if this distance <= k, reduce k by it and append 'a'
            - else if cannot reach a, but a char to the left of current char by k. Append that and reduce k
     */
    public String getSmallestString(String s, int k) {
        StringBuilder stb = new StringBuilder(s.length());
        char currentChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (k > 0) {
                k -= appendAndReduce(stb, currentChar, k);
            } else {
                stb.append(currentChar);
            }
        }
        return stb.toString();
    }

    private int appendAndReduce(StringBuilder stb, char currentChar, int k) {
        int minDistance = Math.min(123 - currentChar, currentChar - 'a');
        if (k >= minDistance) {
            stb.append('a');
            return minDistance;
        } else {
            stb.append((char)(currentChar - k));
            return k;
        }
    }
}
